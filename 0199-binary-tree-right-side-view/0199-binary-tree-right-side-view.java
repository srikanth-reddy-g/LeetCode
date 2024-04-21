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
    public List<Integer> rightSideView(TreeNode root) {
        // Recursive Solution T.C = O(n) and S.C = O(h) 
        // where h = height of tree
        List<Integer> rView = new ArrayList<>();
        recursiveRightView(root, rView, 0);
        return rView;
    }
    public void recursiveRightView(TreeNode root,List<Integer> rView,int level){
        if(root==null)
        return;
        if(level==rView.size()) rView.add(root.val);
        recursiveRightView(root.right, rView, level+1);
        recursiveRightView(root.left, rView, level+1);
    }


        // Iterative method with T.C = O(n), S,C = O(n)
        // Queue<TreeNode> q=new LinkedList<>();
        // List<Integer> rView = new ArrayList<>();
        // if(root==null) return rView;
        // q.add(root);
        // while(!q.isEmpty()){
        //     int qsize= q.size();
        //     for(int i=0;i<qsize;i++){
        //         TreeNode node=q.poll();
        //         if(i==qsize-1) rView.add(node.val);
        //         if(node.left!=null) q.add(node.left);
        //         if(node.right!=null) q.add(node.right);
        //     }
        // }
        // return rView;
    // }
}