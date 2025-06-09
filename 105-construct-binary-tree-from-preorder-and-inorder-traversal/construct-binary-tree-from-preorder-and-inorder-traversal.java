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
            int[] preorder, int preorderStart, int preorderEnd,
            int[] inorder, int inorderStart, int inorderEnd,
            Map<Integer, Integer> inoderIndexMap) {

        if (preorderStart > preorderEnd || inorderStart > inorderEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorderStart]);

        int rootIndexInorder = inoderIndexMap.get(preorder[preorderStart]);
        int leftSubTreeSize = rootIndexInorder - inorderStart;

        root.left = constructTree(
                preorder, preorderStart + 1, preorderStart + leftSubTreeSize,
                inorder, inorderStart, rootIndexInorder - 1,
                inoderIndexMap);

        root.right = constructTree(
                preorder, preorderStart + leftSubTreeSize + 1, preorderEnd,
                inorder, rootIndexInorder + 1, inorderEnd,
                inoderIndexMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inoderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inoderIndexMap.put(inorder[i], i);
        }
        return constructTree(
                preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1,
                inoderIndexMap);
    }
}