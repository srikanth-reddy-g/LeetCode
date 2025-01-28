class LRUCache {
    int capacity;
    Map<Integer, Node> lruMap;
    Node dummyHead;
    Node dummyTail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        lruMap = new HashMap<>();
        dummyHead = new Node(-1, -1);
        dummyTail = new Node(-1, -1);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        if (!lruMap.containsKey(key)) {
            return -1;
        }
        Node keyNode = lruMap.get(key);
        deleteNode(keyNode);
        insertNode(keyNode);
        return keyNode.val;

    }

    public void put(int key, int value) {
        if (lruMap.containsKey(key)) {
            Node existingNode = lruMap.get(key);
            existingNode.val = value;
            deleteNode(existingNode);
            insertNode(existingNode);
        } else {
            if (lruMap.size() == capacity) {
                deleteNode(dummyTail.prev);
            }
            Node newNode = new Node(key, value);
            insertNode(newNode);
        }
    }

    public void deleteNode(Node head) {
        lruMap.remove(head.key);
        head.prev.next = head.next;
        head.next.prev = head.prev;

    }

    public void insertNode(Node head) {
        lruMap.put(head.key, head);
        head.prev = dummyHead;
        head.next = dummyHead.next;
        head.next.prev = head;
        dummyHead.next = head;
    }
}

class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */