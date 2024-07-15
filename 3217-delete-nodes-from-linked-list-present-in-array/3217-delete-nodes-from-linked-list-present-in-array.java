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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        ListNode temp=head;
        while(temp!=null && temp.next!=null){
            if(temp==head && set.contains(temp.val)){
                head=temp.next;
                temp=head;
            }
            else if(set.contains(temp.next.val)){
                temp.next=temp.next.next;
                temp=temp;
            }
            else
            temp=temp.next;
        }
        return head;
    }
}