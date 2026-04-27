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
    public int pairSum(ListNode head) {
        ListNode head2 = reverse(getMid(head));
        int max = Integer.MIN_VALUE;

        while (head != null && head2 != null) {
            max = Math.max(max, head.val + head2.val);
            head = head.next;
            head2 = head2.next;
        }

        return max;
    }

    private ListNode reverse(ListNode h) {
        if (h == null) return null;

        ListNode prev = null;
        ListNode temp = null;

        while (h != null) {
            temp = h.next;
            h.next = prev;
            prev = h;
            h = temp;
        }

        return prev;
    }

    private ListNode getMid(ListNode h) {
        if (h == null) return null;

        ListNode lead = h;
        ListNode lag = h;

        while (lead.next != null && lead.next.next != null) {
            lead = lead.next.next;
            lag = lag.next;
        }

        return lag;
    }
}