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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result= new ArrayList<List<Integer>>();
        if (root==null)
            return result;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        int n=0;
        while(!queue.isEmpty())
        {
            List<Integer> zigzag = new ArrayList<Integer>();
            int qSize=queue.size();
            for(int i=0;i<qSize;i++)
            {
                if(queue.peek().left!=null) 
                    queue.offer(queue.peek().left);
                if(queue.peek().right!=null) 
                    queue.offer(queue.peek().right);
                if(n%2==0)
                    zigzag.add(queue.poll().val);
                else
                    zigzag.add(0,queue.poll().val);
            }
            n++;
            result.add(zigzag);
        }
        return result;
    }
}