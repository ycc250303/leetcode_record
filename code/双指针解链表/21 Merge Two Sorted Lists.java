class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(-1);
        ListNode current = ans;
        ListNode pa = list1;
        ListNode pb = list2;
        while (pa != null && pb != null) {
            int a = pa.val, b = pb.val;
            if (a <= b) {
                current.next = pa;
                pa = pa.next;
            } else {
                current.next = pb;
                pb = pb.next;
            }
            current = current.next;
        }
        if (pa != null) {
            current.next = pa;
        }
        if (pb != null) {
            current.next = pb;
        }
        return ans.next;
    }
}