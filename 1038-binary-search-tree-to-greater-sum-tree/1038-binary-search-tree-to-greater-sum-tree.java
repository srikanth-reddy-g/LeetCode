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
    int max=0;
    public TreeNode bstToGst(TreeNode root) {
        inOrder(root);
        return root;
    }
    public void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.right);
        max+=root.val;
        root.val=max;
        System.out.println(root.val);
        inOrder(root.left);
    }
}