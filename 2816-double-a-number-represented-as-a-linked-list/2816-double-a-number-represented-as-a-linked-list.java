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
    public ListNode doubleIt(ListNode head) {
        ListNode newHead=reverseLL(head);
        ListNode temp=newHead;
        ListNode prev=null;
        int carry=0;
        int num=0;
        while(temp!=null){
            num=temp.val*2+carry;
            temp.val=num%10;
            if(num>9){
                carry =1;
            }
            else {
                carry=0;
            }
            prev=temp;
            temp=temp.next;
        }
        if(carry>0){
            ListNode extraNode=new ListNode(carry);
            prev.next=extraNode;
        }
        return reverseLL(newHead);
    }
    public ListNode reverseLL(ListNode head){
        ListNode temp=head;
        ListNode front=null;
        ListNode prev=null;
        while(temp!=null){
            front = temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
}