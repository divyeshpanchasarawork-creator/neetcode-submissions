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
    public void reorderList(ListNode head) {
        ListNode mid = getMid(head);
        ListNode head2 = reverse(mid);
        merge(head, head2);
    }

    private void merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        boolean flag = true;

        while (head1 != null && head2 != null) {
            if (flag) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
            flag = !flag;
        }

        curr.next = head1 == null ? head2 : head1;
    }

    private ListNode getMid(ListNode head) {
        if (head == null)
            return null;

        ListNode lead = head;
        ListNode lag = head;

        while (lead != null && lead.next != null) {
            lead = lead.next.next;
            lag = lag.next;
        }
        ListNode mid = lag.next;
        lag.next = null;
        return mid;
    }

    private ListNode reverse(ListNode head) {
        if (head == null)
            return null;

        ListNode prev = null;
        ListNode temp = null;

        while (head != null) {
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }
}
