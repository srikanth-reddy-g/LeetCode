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
    public ListNode swapPairs(ListNode head) {
        ListNode temp=head;
        ListNode prevNode=null;
        ListNode nextNode=null;
        while(temp!=null){
            ListNode adjNode=temp.next;
            if(adjNode==null){
                if(prevNode!=null) prevNode.next=temp;
                break;
            }
            nextNode=adjNode.next;
            adjNode.next=null;
            reverseLL(temp);
            if(temp==head){
                head=adjNode;
            }
            else{
                prevNode.next=adjNode;
            }
            prevNode=temp;
            temp=nextNode;
        }
        return head;
        
    }
    public void reverseLL(ListNode temp){
        ListNode prev= null;
        ListNode future=null;
        while(temp!=null){
            future= temp.next;
            temp.next=prev;
            prev=temp;
            temp=future;
        }
    }
}