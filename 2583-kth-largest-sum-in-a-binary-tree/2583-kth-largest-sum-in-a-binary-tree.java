/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        q.add(root);
        long sum = 0;
        while (!q.isEmpty()) {
            sum = 0;
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode node = q.poll();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                sum = sum + node.val;
            }
            pq.add(sum);
        }
        sum = 0;
        while (k-- > 0) {
            if (! pq.isEmpty() )sum = pq.poll();
            else return -1;
        }
        return sum;
    }
}