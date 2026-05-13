/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node curr = head;
        Node dummy = new Node(-1);
        Node prev = dummy;

        while (curr != null) {
            Node node = new Node(curr.val);
            prev.next = node;
            prev = node;

            map.put(curr, node);
            curr = curr.next;
        }

        curr = head;
        Node temp = dummy.next;
        while (curr != null) {
            temp.random = map.get(curr.random);
            curr = curr.next;
            temp = temp.next;
        }

        return dummy.next;

    }
}
