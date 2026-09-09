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
        if(head == null){
            return null;
        }
        ListNode last = head;
        int n = 1;
        //find n and last
        while(last.next != null){
            n++;
            last = last.next;
        }

        k = k % n;
        if(k == 0){
            return head;
        }

        // find n-k and n-k+1
         int count = 1 ;
         ListNode t = head;
        
        while (count < n - k) {
            count++;
            t = t.next;
        }
         last.next = head;
         ListNode res= t.next;
         t.next = null;
         return res;
    }
}