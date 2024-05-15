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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp=head;
        int length=0;
        if (head==null) return null;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        k=k%length;
        if (k==0) return head;
        int cnt=1;
        temp=head;
        ListNode front=null;
        ListNode newHead=null;
        while(temp.next!=null){
            front=temp.next;
            if(cnt==length-k){
                newHead=temp.next;
                temp.next=null;
            }
            cnt++;
            temp=front;
        }
        temp.next=head;
        return newHead;
    }
}