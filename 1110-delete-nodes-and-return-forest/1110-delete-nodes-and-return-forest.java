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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Queue<TreeNode> q=new LinkedList<>();
        List<TreeNode> ans=new ArrayList<>();
        Set<Integer> deleteNodes=new HashSet<>();
        for(int i=0;i<to_delete.length;i++) deleteNodes.add(to_delete[i]);
        q.add(root);
        if(!deleteNodes.contains(root.val)) ans.add(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node.left!=null){
                q.add(node.left);
                if(deleteNodes.contains(node.val)){
                    ans.add(node.left);
                    if(deleteNodes.contains(node.left.val)) {
                        ans.remove(ans.size()-1);
                    }
                }
                if(deleteNodes.contains(node.left.val)) node.left=null;
            }
            if(node.right!=null){
                q.add(node.right);
                if(deleteNodes.contains(node.val)){
                    ans.add(node.right);
                    if(deleteNodes.contains(node.right.val)) {
                        ans.remove(ans.size()-1);
                    }
                }
                if(deleteNodes.contains(node.right.val)) node.right=null;
            }
        }
        return ans;
    }
}