class Node {
    int val;
    Node next;
    Node prev;

    public Node(int val) {
        this.val = val;
    }
}

class MyLinkedList {

    Node dummyHead;
    Node dummyTail;
    int length;

    public MyLinkedList() {
        length = 0;
        dummyHead = new Node(0);
        dummyTail = new Node(0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int index) {
        if (index < 0 || index >= length)
            return -1;
        Node temp = dummyHead.next;
        while (temp.next != null) {
            if (index == 0) {
                return temp.val;
            }
            index--;
            temp = temp.next;
        }
        return -1;
    }

    public void addAtHead(int val) {
        Node headNode = new Node(val);
        headNode.next = dummyHead.next;
        headNode.prev = dummyHead;
        dummyHead.next.prev = headNode;
        dummyHead.next = headNode;
        length++;
    }

    public void addAtTail(int val) {
        Node tailNode = new Node(val);
        tailNode.next = dummyTail;
        tailNode.prev = dummyTail.prev;
        dummyTail.prev.next = tailNode;
        dummyTail.prev = tailNode;
        length++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > length)
            return;
        if (index == length) {
            addAtTail(val);
            return;
        }
        Node temp = dummyHead.next;
        while (temp.next != null) {
            if (index == 0) {
                Node newNode = new Node(val);
                newNode.next = temp;
                newNode.prev = temp.prev;
                temp.prev.next = newNode;
                temp.prev = newNode;
                length++;
                break;
            }
            index--;
            temp = temp.next;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length)
            return;
        Node temp = dummyHead.next;
        while (temp.next != null) {
            if (index == 0) {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                length--;
                break;
            }
            index--;
            temp = temp.next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */