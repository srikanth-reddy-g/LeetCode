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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp=head;
        ListNode reversedHead=reverseLL(temp);
        ListNode rightNode=travelKDistance(reversedHead,k);
        int rightValue=rightNode.val;
        temp=reverseLL(reversedHead);
        ListNode leftNode=travelKDistance(temp,k);
        rightNode.val=leftNode.val;
        leftNode.val=rightValue;
        return head;
    }
    private ListNode travelKDistance(ListNode head,int k){
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            count++;
            if(count==k){
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }
    private ListNode reverseLL(ListNode head){
        ListNode temp=head;
        ListNode front= null;
        ListNode prev=null;
        while(temp!=null){
            front= temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
}