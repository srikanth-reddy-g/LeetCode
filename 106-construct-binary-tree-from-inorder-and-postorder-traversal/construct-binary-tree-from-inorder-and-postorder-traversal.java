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
    private TreeNode constructTree(
            int inorder[], int inorderStart, int inorderEnd,
            int postorder[], int postorderStart, int postorderEnd,
            Map<Integer, Integer> inorderIndexMap) {
        if (inorderStart > inorderEnd || postorderStart > postorderEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorderEnd]);
        int inorderIndexPosition = inorderIndexMap.get(postorder[postorderEnd]);
        int leftSubTreeLength = inorderIndexPosition - inorderStart;
        root.left = constructTree(
                inorder, inorderStart, inorderIndexPosition - 1,
                postorder, postorderStart, postorderStart + leftSubTreeLength - 1,
                inorderIndexMap);
        root.right = constructTree(
                inorder, inorderIndexPosition + 1, inorderEnd,
                postorder, postorderStart + leftSubTreeLength, postorderEnd - 1,
                inorderIndexMap);
        return root;

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return constructTree(
                inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1,
                inorderIndexMap);
    }
}