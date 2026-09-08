class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        ListNode t = head;
        ListNode before = null;
        int pos = 1;

        // Reach the left position
        while (pos < left) {
            before = t;
            t = t.next;
            pos++;
        }

        // t is the first node that needs to be reversed
        ListNode leftNode = t;

        ListNode curr = t;
        ListNode prev = null;

        int times = right - left + 1;

        // Reverse left to right
        while (times > 0) {
            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;

            times--;
        }

        // Connect the reversed part to the remaining list
        leftNode.next = curr;

        // If reversal started from head
        if (before == null) {
            return prev;
        }

        // Connect previous part to reversed part
        before.next = prev;

        return head;
    }
}