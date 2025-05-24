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
    public ListNode partition(ListNode head, int x) {
        ListNode initialLess = new ListNode(-1);
        ListNode less = initialLess;
        ListNode initialGreat = new ListNode(-1);
        ListNode great = initialGreat;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val < x) {
                less.next = temp;
                less = less.next;
            } else {
                great.next = temp;
                great = great.next;
            }
            temp = temp.next;
        }
        great.next = null;
        less.next = initialGreat.next;
        return initialLess.next;
    }
}