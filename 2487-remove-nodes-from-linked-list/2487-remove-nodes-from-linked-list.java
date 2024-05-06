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
    public ListNode removeNodes(ListNode head) {
        ListNode newHead=reverseLL(head);
        ListNode temp= newHead;
        int maxNum=-1;
        int flag=0;
        ListNode prev=newHead;
        while(temp!=null){
            if(temp.val>=maxNum){
                maxNum=temp.val;
                if(flag!=0)
                prev.next=temp;
                prev=temp;
                temp=temp.next;
                flag=1;
            }
            else{
                // prev.next=temp;
                temp=temp.next;
            }
            
        }
        prev.next=null;

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