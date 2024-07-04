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
    public ListNode mergeNodes(ListNode head) {
        ListNode right=head;
        ListNode left=head;
        int sum=0;
        while(right.next!=null){
            if(right.next.val==0){
                left.val=sum;
                if(right.next.next==null){
                    left.next=right.next.next;
                    break;
                }
                left.next=right.next;
                left=right.next;
                sum=0;
            }else{
                sum+=right.next.val;
            }
            right=right.next;
        }
        return head;
    }
}