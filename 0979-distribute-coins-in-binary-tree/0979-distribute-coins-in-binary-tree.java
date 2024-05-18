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
    public int distributeCoins(TreeNode root) {
        int moves[]=new int[1];
        dfs(root,moves);
        return moves[0];
        
    }
    public int dfs(TreeNode root, int moves[]){
        if(root==null)
        return 0;
        int leftTreeCoins=dfs(root.left,moves);
        int rightTreeCoins=dfs(root.right,moves);
        moves[0]+=Math.abs(leftTreeCoins)+Math.abs(rightTreeCoins);
        return root.val-1+leftTreeCoins+rightTreeCoins;
    }
}