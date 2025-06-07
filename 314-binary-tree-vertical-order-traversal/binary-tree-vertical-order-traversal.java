/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair {
    TreeNode node;
    int column;

    public Pair(TreeNode node, int column) {
        this.node = node;
        this.column = column;
    }
}

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Map<Integer, List<Integer>> mpp = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode currentNode = pair.node;
            int column = pair.column;
            if (!mpp.containsKey(column))
                mpp.put(column, new ArrayList<Integer>());
            mpp.get(column).add(currentNode.val);
            if (currentNode.left != null)
                queue.offer(new Pair(currentNode.left, column - 1));
            if (currentNode.right != null)
                queue.offer(new Pair(currentNode.right, column + 1));
        }
        for (Map.Entry<Integer, List<Integer>> values : mpp.entrySet()) {
            ans.add(values.getValue());
        }
        return ans;
    }

}