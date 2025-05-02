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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int ans[][] = new int[m][n];
        int top = 0, left = 0;
        int bottom = m - 1;
        int right = n - 1;
        ListNode temp = head;
        while (left <= right && top <= bottom) {
            //left->right
            for (int i = left; i <= right; i++) {
                if (temp != null) {
                    ans[top][i] = temp.val;
                    temp = temp.next;
                } else {
                    ans[top][i] = -1;
                }
            }
            top++;
            //top->bottom
            for (int i = top; i <= bottom; i++) {
                if (temp != null) {
                    ans[i][right] = temp.val;
                    temp = temp.next;
                } else {
                    ans[i][right] = -1;
                }
            }
            right--;
            //right->left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    if (temp != null) {
                        ans[bottom][i] = temp.val;
                        temp = temp.next;
                    } else {
                        ans[bottom][i] = -1;
                    }
                }
            }
            bottom--;
            //bottom->top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    if (temp != null) {
                        ans[i][left] = temp.val;
                        temp = temp.next;
                    } else {
                        ans[i][left] = -1;
                    }
                }
            }
            left++;
        }
        return ans;
    }
}