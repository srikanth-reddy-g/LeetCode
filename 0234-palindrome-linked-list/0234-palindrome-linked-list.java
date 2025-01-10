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
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverseLL(slow.next);
        ListNode first = head;
        ListNode last = newHead;
        while (last != null) {
            if (first.val == last.val) {
                first = first.next;
                last = last.next;
            } else {
                reverseLL(newHead);
                return false;
            }
        }
        reverseLL(newHead);
        return true;
    }

    public ListNode reverseLL(ListNode node) {
        if (node == null || node.next == null)
            return node;
        ListNode newHead = reverseLL(node.next);
        ListNode front = node.next;
        front.next = node;
        node.next = null;
        return newHead;
    }
}