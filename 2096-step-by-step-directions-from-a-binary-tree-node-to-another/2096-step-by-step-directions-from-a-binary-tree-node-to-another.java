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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lowestCommonAncestor=findLCS(root,startValue,destValue);
        StringBuilder lcaToStartPath=new StringBuilder();
        StringBuilder lcaToDestPath=new StringBuilder();
        findPath(lowestCommonAncestor,startValue,lcaToStartPath);
        findPath(lowestCommonAncestor,destValue,lcaToDestPath);
        StringBuilder result=new StringBuilder();
        for(int i=0;i<lcaToStartPath.length();i++){
            result.append("U");
        }
        return result.append(lcaToDestPath).toString();
    }
    public TreeNode findLCS(TreeNode root, int start, int dest){
        if (root==null) {
            return null;
        }
        if (root.val==start || root.val==dest){
            return root;
        }
        TreeNode leftLCA=findLCS(root.left,start,dest);
        TreeNode rightLCA=findLCS(root.right,start,dest);

        if(leftLCA == null) return rightLCA;
        else if (rightLCA == null) return leftLCA;
        else return root;

    }
    public boolean findPath(TreeNode root,int dest, StringBuilder path){
        if(root==null){
            return false;
        }
        if(root.val==dest) return true;
        path.append("L");
        if (findPath(root.left,dest,path)) return true;
        path.setLength(path.length()-1);
        path.append("R");
        if (findPath(root.right,dest,path)) return true;
        path.setLength(path.length()-1);
        return false;

    }
}