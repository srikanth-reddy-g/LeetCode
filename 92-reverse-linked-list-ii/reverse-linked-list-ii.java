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
    private ListNode reverseLL(ListNode head, int len) {
        ListNode prev = null;
        ListNode temp = head;
        ListNode front = head;
        while (temp != null) {
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
            len--;
            if (len == 0)
                break;
        }
        head.next = front;
        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = head;
        ListNode prev = null;
        int len = right - left + 1;
        while (temp != null) {
            left--;
            if (left == 0) {
                ListNode newHead = reverseLL(temp, len);
                if (prev == null) {
                    return newHead;
                }
                prev.next = newHead;
                return head;
            }
            prev = temp;
            temp = temp.next;
        }
        return null;
    }
}