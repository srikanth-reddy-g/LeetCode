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
    public List<Integer> preorderTraversal(TreeNode root) {
        // preorder traversal using recursion
        List<Integer> preorder = new ArrayList<>();
        preOrder(root,preorder);
        return preorder;
    }
    // Recursive function to find the preorder traversal
    public void preOrder(TreeNode root , List<Integer> preorder)
    {
        //base case
        if(root==null)
        return;
        preorder.add(root.val);
        preOrder(root.left,preorder);
        preOrder(root.right,preorder);
    }
    // preorder traversal using a stack
    // List<Integer> preorder = new ArrayList<>();
    // Stack<TreeNode> st= new Stack<>();
    // if(root == null) return preorder;
    // st.push(root);
    // while(!st.empty()){
    //     TreeNode node=st.pop();
    //     preorder.add(node.val);
    //     if(node.right!=null) st.push(node.right);
    //     if(node.left!=null) st.push(node.left);
    // }
    // return preorder;
    // }
}