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

    public int getDecimalValue(ListNode head) {
        ListNode temp = reverseLL(head);
        int pow = 1;
        int ans = 0;
        while (temp != null) {
            if (temp.val == 1)
                ans += pow;
            pow *= 2;
            temp = temp.next;
        }
        return ans;
    }
    //     public int getDecimalValue(ListNode head) {
    //     ListNode temp = head;
    //     StringBuilder sb = new StringBuilder();
    //     while (temp != null) {
    //         sb.append(temp.val);
    //         temp = temp.next;
    //     }
    //     int pow = 1;
    //     int ans = 0;
    //     for (int i = sb.length() - 1; i >= 0; i--) {
    //         if (sb.charAt(i) == '1')
    //             ans += pow;
    //         pow *= 2;
    //     }
    //     return ans;
    // }
}