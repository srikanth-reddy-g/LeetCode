/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        // Create deepCopy of new Nodes in between the existing nodes
        while (temp != null) {
            Node deepCopyNode = new Node(temp.val);
            deepCopyNode.next = temp.next;
            temp.next = deepCopyNode;
            temp = deepCopyNode.next;
        }
        temp = head;
        // Replicate the randonm pointers of the existing Nodes to the new deepCopy Nodes
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        // Seperate the new deepCopy Nodes from the existing nodes
        temp = head;
        Node dummyNode = new Node(-1);
        Node res = dummyNode;
        while (temp != null) {
            res.next = temp.next;
            temp.next = temp.next.next;
            res = res.next;
            temp = temp.next;
        }
        return dummyNode.next;
        // Time Complexity - O(N)+O(N)+O(N) ~ O(N)
        //Space Complexity - O(1)



        // Better Approach
        // Time Complexity - O(N)+O(N)= O(N)
        //Space Complexity - O(N)
        // Map<Node, Node> deepCopyNodes = new HashMap<>();
        // Node temp = head;
        // Node dummyNode = new Node(-1);
        // Node res = dummyNode;
        // while (temp != null) {
        //     Node deepCopyNode = new Node(temp.val);
        //     res.next = deepCopyNode;
        //     res = res.next;
        //     deepCopyNodes.put(temp, deepCopyNode);
        //     temp = temp.next;
        // }
        // temp = head;
        // res = dummyNode.next;
        // while (temp != null) {
        //     if (temp.random != null) {
        //         res.random = deepCopyNodes.get(temp.random);
        //     } else {
        //         res.random = null;
        //     }
        //     res = res.next;
        //     temp = temp.next;
        // }
        // return dummyNode.next;
    }
}