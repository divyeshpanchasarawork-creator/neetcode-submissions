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

    private void merge(ListNode h1, ListNode h2) {
        while (h2 != null) {
            ListNode next1 = h1.next;
            ListNode next2 = h2.next;
            h1.next = h2;
            h2.next = next1;
            h1 = next1;
            h2 = next2;
        }
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
