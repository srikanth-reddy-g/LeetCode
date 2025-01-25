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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        ListNode temp = null;
        for (int i = 0; i < lists.length; i++) {
            temp = merge2Lists(temp, lists[i]);
        }
        return temp;
    }

    private ListNode merge2Lists(ListNode head1, ListNode head2) {
        ListNode newHead = new ListNode(-1, null);
        ListNode temp = newHead;
        ListNode temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val > temp2.val) {
                temp.next = temp2;
                temp2 = temp2.next;
                temp = temp.next;
            } else {
                temp.next = temp1;
                temp1 = temp1.next;
                temp = temp.next;
            }
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else {
            temp.next = temp2;
        }
        return newHead.next;
    }
}