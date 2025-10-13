class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return null;
        ListNode fast = head, slow = head;
        int p = 0;
        while (p < n) {
            fast = fast.next;
            p++;
        }
        if (fast == null)
            return head.next;

        fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}