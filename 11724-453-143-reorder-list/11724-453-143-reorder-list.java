/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp1 = head;
        ListNode temp2 = reverseLL(slow.next);
        slow.next = null;
        while (temp1 != null && temp2 != null) {
            ListNode front1 = temp1.next;
            ListNode front2 = temp2.next;
            temp1.next = temp2;
            temp2.next = front1;
            temp1 = front1;
            temp2 = front2;
        }

    }

    private ListNode reverseLL(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        ListNode front = null;
        while (temp != null) {
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}