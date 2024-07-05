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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode temp=head.next;
        int prevValue=head.val;
        int result[]={-1,-1};
        int nodeCount=2;
        int first=0;
        int last=-1;
        int prevLast=0;
        int localMaxOrMinCount=0;
        int minValue=Integer.MAX_VALUE;
        while(temp.next!=null ){
            if((prevValue>temp.val && temp.next.val>temp.val) ||
            (prevValue<temp.val && temp.next.val<temp.val)){
                if(first==0 && last==-1 && prevLast==0){
                    first=nodeCount;
                    last=nodeCount;
                    prevLast=nodeCount;
                }
                else{
                    prevLast=last;
                    last=nodeCount;
                }
                if(last!= prevLast) minValue=Math.min(minValue,last-prevLast);
                localMaxOrMinCount++;
            }
            prevValue=temp.val;
            temp=temp.next;
            nodeCount++;
        }
        if(localMaxOrMinCount>=2){
            result[0]=minValue;
            result[1]=last-first;
        }
        return result;
    }
}