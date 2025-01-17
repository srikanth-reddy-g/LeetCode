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
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        int cnt = 0;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            if (cnt != 0)
                slow = slow.next;
            fast = fast.next.next;
            cnt++;
        }
        slow.next = slow.next.next;
        return head;
        // int n = 0;
        // ListNode temp = head;
        // while(temp!=null)
        // {
        // n++;
        // temp=temp.next;
        // }
        // int cnt = (n/2);
        // temp=head;
        // while(temp!=null)
        // {
        // cnt--;
        // if(cnt==0)
        // {
        // temp.next=temp.next.next;
        // break;
        // }
        // temp=temp.next;
        // }
        // return head;

        // Worst than brute force
        // ListNode temp=head;
        // if (head == null || head.next == null) {
        // return null;
        // }
        // int n=-1;
        // while (temp!=null)
        // {
        // n++;
        // temp=temp.next;
        // }
        // int cnt=-1;
        // ListNode temp1=head;
        // ListNode prev=null;
        // ListNode prev1=null;
        // while(temp1!=null)
        // {
        // cnt++;
        // prev1=prev;
        // prev=temp1;
        // temp1=temp1.next;
        // if(cnt==n/2 && n%2!=0)
        // {
        // prev.next=prev.next.next;
        // break;
        // }
        // else if(cnt==n/2 && n%2==0)
        // {
        // prev1.next=prev1.next.next;
        // break;
        // }
        // }
        // return head;
    }
}