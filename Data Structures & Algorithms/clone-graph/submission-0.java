/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Queue<Node> q = new ArrayDeque<>();
        Map<Integer, Node> visited = new HashMap<>();

        q.offer(node);
        visited.put(node.val, new Node(node.val));

        while (!q.isEmpty()) {
            Node curr = q.poll();

            Node newNode = visited.get(curr.val);

            for (Node child : curr.neighbors) {
                if (!visited.containsKey(child.val)) {
                    q.offer(child);
                    visited.put(child.val, new Node(child.val));
                }
                newNode.neighbors.add(visited.get(child.val));
            }
        }

        return visited.get(node.val);
    }
}