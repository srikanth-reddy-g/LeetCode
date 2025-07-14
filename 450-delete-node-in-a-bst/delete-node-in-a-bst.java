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
    private void connectRemainingTree(TreeNode leftNode, TreeNode rightNode) {
        while (leftNode.right != null) {
            leftNode = leftNode.right;
        }
        leftNode.right = rightNode;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;
        if(root.val==key){
            if(root.left==null) return root.right;
            connectRemainingTree(root.left, root.right);
            return root.left;
        }
        TreeNode temp = root;
        while (temp != null) {
            if (temp.left != null && temp.left.val == key) {
                TreeNode leftNode = temp.left.left;
                TreeNode rightNode = temp.left.right;
                if (leftNode == null) {
                    temp.left = rightNode;
                    break;
                }
                connectRemainingTree(leftNode, rightNode);
                temp.left = leftNode;
                break;
            } else if (temp.right != null && temp.right.val == key) {
                TreeNode leftNode = temp.right.left;
                TreeNode rightNode = temp.right.right;
                if (leftNode == null) {
                    temp.right = rightNode;
                    break;
                }
                connectRemainingTree(leftNode, rightNode);
                temp.right = leftNode;
                break;
            }
            if (temp.val > key) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return root;
    }
}