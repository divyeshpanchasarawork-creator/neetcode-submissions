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
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode mid = getMid(head);
        mid = reverse(mid);
        while (head != null && mid != null) {
            if (head.val != mid.val) return false;
            head = head.next;
            mid = mid.next;
        }

        return true;
    }

    private ListNode getMid(ListNode head) {
        ListNode lead = head;
        ListNode lag = head;

        while (lead.next != null && lead.next.next != null) {
            lead = lead.next.next;
            lag = lag.next;
        }

        return lag;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) return null;

        ListNode prev = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}