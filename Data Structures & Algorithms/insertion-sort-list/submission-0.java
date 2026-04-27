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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = getMid(head);
        ListNode rightHalf = mid.next;
        mid.next = null;

        ListNode left = insertionSortList(head);
        ListNode right = insertionSortList(rightHalf);

        return merge(left, right);
    }

    private ListNode getMid(ListNode head) {
        if (head == null) return null;

        ListNode lead = head;
        ListNode lag = head;

        while (lead.next != null && lead.next.next != null) {
            lead = lead.next.next;
            lag = lag.next;
        }

        return lag;
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(-1, h1);
        ListNode curr = dummy;

        while (h1 != null && h2 != null) {
            if (h1.val <= h2.val) {
                curr.next = h1;
                h1 = h1.next;
            } else {
                curr.next = h2;
                h2 = h2.next;
            }
            curr = curr.next;
        }

        curr.next = h1 == null ? h2 : h1;

        return dummy.next;
    }
}