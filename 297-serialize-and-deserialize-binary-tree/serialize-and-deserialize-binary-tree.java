/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeBinaryTree(root, sb);
        return sb.toString();
    }

    private void serializeBinaryTree(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("$ ");
            return;
        }
        sb.append(root.val + " ");
        serializeBinaryTree(root.left, sb);
        serializeBinaryTree(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> nodeValues = new LinkedList<>(Arrays.asList(data.split(" ")));
        return constructBinaryTree(nodeValues);
    }

    private TreeNode constructBinaryTree(List<String> nodeValues) {
        if (nodeValues.get(0).equals("$")) {
            nodeValues.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodeValues.get(0)));
        nodeValues.remove(0);
        root.left = constructBinaryTree(nodeValues);
        root.right = constructBinaryTree(nodeValues);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));