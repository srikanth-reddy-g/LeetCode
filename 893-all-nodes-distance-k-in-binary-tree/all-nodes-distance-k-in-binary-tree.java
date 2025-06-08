/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void findParentNodes(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        if (root == null)
            return;
        if (root.left != null)
            parentMap.put(root.left, root);
        if (root.right != null)
            parentMap.put(root.right, root);
        findParentNodes(root.left, parentMap);
        findParentNodes(root.right, parentMap);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        findParentNodes(root, parentMap);
        List<Integer> ans = new ArrayList<>();
        Map<TreeNode, Boolean> vis = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        vis.put(target, true);
        int level = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null && vis.get(currentNode.left) == null) {
                    queue.offer(currentNode.left);
                    vis.put(currentNode.left, true);
                }
                if (currentNode.right != null && vis.get(currentNode.right) == null) {
                    queue.offer(currentNode.right);
                    vis.put(currentNode.right, true);
                }
                if (parentMap.get(currentNode) != null && vis.get(parentMap.get(currentNode)) == null) {
                    queue.offer(parentMap.get(currentNode));
                    vis.put(parentMap.get(currentNode), true);
                }
                if (level == k) {
                    ans.add(currentNode.val);
                }
            }
            if (level == k)
                break;
            level++;
        }
        return ans;
    }
}