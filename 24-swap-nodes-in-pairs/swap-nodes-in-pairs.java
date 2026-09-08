class Solution {

    public ListNode reverse(ListNode head, int times) {

        ListNode curr = head;
        ListNode prev = null;

        while (times > 0) {

            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;

            times--;
        }

        return prev;
    }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode left = head;
        ListNode prevleft = null;
        ListNode res = null;

        int size = 2;

        while (left != null) {

            // Find the second node
            ListNode right = left;

            for (int i = 0; i < size - 1; i++) {

                if (right == null) {
                    break;
                }

                right = right.next;
            }

            // Not enough nodes for a pair
            if (right == null) {

                if (prevleft != null) {
                    prevleft.next = left;
                }

                break;
            }

            // Save node after the pair
            ListNode nextleft = right.next;

            // Reverse the pair
            ListNode newHead = reverse(left, size);

            // left is now the TAIL of reversed pair
            left.next = nextleft;

            // Connect previous pair
            if (prevleft != null) {
                prevleft.next = newHead;
            }

            // Store answer
            if (res == null) {
                res = newHead;
            }

            // Move to next pair
            prevleft = left;
            left = nextleft;
        }

        return res;
    }
}