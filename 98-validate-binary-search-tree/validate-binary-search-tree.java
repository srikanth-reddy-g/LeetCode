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
    public boolean isValidBST(TreeNode root) {
        return isTreeBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isTreeBST(TreeNode root, long mini, long maxi) {
        if (root == null)
            return true;
        if (root.val <= mini || root.val >= maxi)
            return false;
        return isTreeBST(root.left, mini, root.val) && isTreeBST(root.right, root.val, maxi);
    }
}