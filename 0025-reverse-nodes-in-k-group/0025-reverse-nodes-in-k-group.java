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
    public ListNode reverseKGroup(ListNode head, int k) {
        int length=0;
        ListNode temp=head;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        int kGroups=length/k;
        temp=head;
        ListNode prevNode=null;
        while(kGroups!=0){
            ListNode kNode=temp;
            for(int i=0;i<k-1;i++){
                kNode=kNode.next;
            }
            ListNode nextNode=kNode.next;
            kNode.next=null;
            ListNode newHead=reverseLL(temp);
            if(temp==head){
                head=kNode;
            }
            else{
                prevNode.next=kNode;
            }
            prevNode=temp;
            temp=nextNode;
            kGroups--;
        }
        prevNode.next=temp;
        return head;
    }
    public ListNode reverseLL(ListNode temp){
        ListNode prev=null;
        ListNode future=null;
        while(temp!=null){
            future=temp.next;
            temp.next=prev;
            prev=temp;
            temp=future;
        }
        return prev;

    }
}