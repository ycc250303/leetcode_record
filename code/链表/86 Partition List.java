class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode h1 = new ListNode(-1), h2 = new ListNode(-1), p = head;
        ListNode p1 = h1, p2 = h2;
        while (p != null) {

            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            ListNode tmp = p.next;
            p.next = null;
            p = tmp;
        }
        p1.next = h2.next;
        return h1.next;
    }
}