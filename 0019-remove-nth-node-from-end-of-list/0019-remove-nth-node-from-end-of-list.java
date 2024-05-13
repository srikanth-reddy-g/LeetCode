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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead=reverseLL(head);
        ListNode temp=newHead;
        ListNode prev=null;
        int cnt=1;
        if (n==1) return reverseLL(newHead.next);
        else{
            while(temp!=null){
                if(n==cnt){
                    prev.next=temp.next;
                    break;
                }
                cnt++;
                prev=temp;
                temp=temp.next;
            }
        }
        return reverseLL(newHead);
    }
    public ListNode reverseLL(ListNode head){
        ListNode temp=head;
        ListNode prev=null;
        ListNode front=null;
        while(temp!=null){
            front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
}