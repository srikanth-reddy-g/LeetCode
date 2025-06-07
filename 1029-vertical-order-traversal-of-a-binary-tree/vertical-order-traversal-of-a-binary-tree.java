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
class NodePosition {
    TreeNode node;
    int column;
    int row;

    public NodePosition(TreeNode node, int column, int row) {
        this.node = node;
        this.column = column;
        this.row = row;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<NodePosition> q = new LinkedList<>();
        Map<Integer, Map<Integer, ArrayList>> mpp = new HashMap<>();
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        q.offer(new NodePosition(root, 0, 0));
        while (!q.isEmpty()) {
            NodePosition current = q.poll();
            TreeNode currentNode = current.node;
            int column = current.column;
            int row = current.row;
            if (!mpp.containsKey(column))
                mpp.put(column, new TreeMap<Integer, ArrayList>());
            if (!mpp.get(column).containsKey(row))
                mpp.get(column).put(row, new ArrayList<>());
            mpp.get(column).get(row).add(currentNode.val);
            minCol = Math.min(minCol, column);
            maxCol = Math.max(maxCol, column);
            if (currentNode.left != null)
                q.offer(new NodePosition(currentNode.left, column - 1, row + 1));
            if (currentNode.right != null)
                q.offer(new NodePosition(currentNode.right, column + 1, row + 1));
        }
        for (int i = minCol; i <= maxCol; i++) {
            List<Integer> verticalValues = new ArrayList<>();
            for (Map.Entry<Integer, ArrayList> values : mpp.get(i).entrySet()) {
                Collections.sort(values.getValue());
                verticalValues.addAll(values.getValue());
            }
            ans.add(verticalValues);
        }
        return ans;
    }
}