/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode present = head;
        ListNode prev = null;
        ListNode future = null;
        while (present != null) {
            future = present.next;
            present.next = prev;
            prev = present;
            present = future;
        }
        return prev;

    }
}