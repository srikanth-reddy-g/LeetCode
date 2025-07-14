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
    int count = 0;

    private void traverseBST(TreeNode root, int k) {
        if (root == null)
            return;
        traverseBST(root.left, k);
        count++;
        if (k == count)
            ans = root.val;
        traverseBST(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        traverseBST(root, k);
        return ans;
    }
}