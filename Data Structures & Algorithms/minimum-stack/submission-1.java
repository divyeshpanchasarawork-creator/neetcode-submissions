class MinStack {

    class Node {
        int val;
        int min;
        Node next;

        Node (int val) {
            this.val = val;
        }
    }
    
    private Node head;

    public MinStack() {
        
    }
    
    public void push(int val) {
        Node node = new Node(val);
        if (head == null) {
            this.head = node;
            this.head.min = val;
            return;
        }
        node.next = this.head;
        node.min = Math.min(val, node.next.min);
        this.head = node; 
    }
    
    public void pop() {
        this.head = this.head.next;
    }
    
    public int top() {
        return this.head.val;
    }
    
    public int getMin() {
        return this.head.min;
    }
}
