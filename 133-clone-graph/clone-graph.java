/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return node;
        Node root = new Node(node.val, new ArrayList<Node>());
        Map<Node, Node> mpp = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        mpp.put(node, root);
        while (!q.isEmpty()) {
            Node top = q.poll();
            for (Node neighbor : top.neighbors) {
                if (!mpp.containsKey(neighbor)) {
                    Node newNode = new Node(neighbor.val, new ArrayList<Node>());
                    mpp.get(top).neighbors.add(newNode);
                    q.offer(neighbor);
                    mpp.put(neighbor, newNode);
                } else {
                    mpp.get(top).neighbors.add(mpp.get(neighbor));
                }
            }
        }
        return root;
    }
}