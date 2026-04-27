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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int size = 1;
        ListNode curr = head;
        while (curr.next != null) {
            size++;
            curr = curr.next;
        }
        k %= size;
        curr.next = head;
        int temp = size - k;
        while (temp-- > 0) {
            head = head.next;
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }
}