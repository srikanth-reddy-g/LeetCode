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
class Solution {
    int ans = 0;

    private void countGoodNodes(TreeNode root, int maxi) {
        if (root == null) {
            return;
        }
        if (root.val >= maxi) {
            maxi = root.val;
            ans++;
        }
        countGoodNodes(root.left, maxi);
        countGoodNodes(root.right, maxi);
    }

    public int goodNodes(TreeNode root) {
        countGoodNodes(root, Integer.MIN_VALUE);
        return ans;
    }
}