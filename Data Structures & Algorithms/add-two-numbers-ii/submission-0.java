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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return reverseList(helper(reverseList(l1), reverseList(l2)));
    }

    private ListNode helper(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0, l1);
        ListNode prev = null;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            l1.val = sum % 10;
            carry = sum / 10;
            prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l2 != null) {
            if (prev == null) {
                dummy.next = l2;
            } else {
                prev.next = l2;
            }
            l1 = l2;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            l1.val = sum % 10;
            carry = sum / 10;
            prev = l1;
            l1 = l1.next;
        }
        if (carry == 1)
            prev.next = new ListNode(carry);

        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = null;

        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}