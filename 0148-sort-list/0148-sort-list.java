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
    public ListNode sortList(ListNode head) {
        ListNode temp = head;
        temp = mergeSort(head);
        return temp;
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode firstHalf = head;
        ListNode secondHalf = mid.next;
        mid.next = null;
        firstHalf = mergeSort(head);
        secondHalf = mergeSort(secondHalf);
        return merge(firstHalf, secondHalf);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead;
        while (first != null && second != null) {
            if (first.val > second.val) {
                temp.next = second;
                second = second.next;
            } else {
                temp.next = first;
                first = first.next;
            }
            temp = temp.next;
        }
        if (first != null) {
            temp.next = first;
        } else {
            temp.next = second;
        }
        return dummyHead.next;
    }
}