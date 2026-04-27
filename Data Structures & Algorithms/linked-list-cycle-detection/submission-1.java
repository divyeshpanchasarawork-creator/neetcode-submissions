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
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode lag = head;
        ListNode lead = head;

        while (lead.next != null && lead.next.next != null) {
            lead = lead.next.next;
            lag = lag.next;

            if (lead == lag) return true;
        }

        return false;
    }
}
