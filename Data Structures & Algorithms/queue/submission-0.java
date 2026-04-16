class Deque {

    class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        } 
    }

    public Deque() {

    }

    private Node head;
    private Node tail;
    private int size;

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void append(int value) {
        Node node = new Node(value);
        this.size++;
        if (this.head == null) {
            this.head = this.tail = node;
            return;
        }
        this.tail.right = node;
        node.left = this.tail;
        this.tail = node;
    }

    public void appendleft(int value) {
        if (this.head == null) {
            append(value);
            return;
        }
        Node node = new Node(value);
        node.right = this.head;
        this.head.left = node;
        this.head = node;
        this.size++;
    }

    public int pop() {
        if (this.head == null) return -1;
        else if (this.size == 1) {
            int val = this.head.val;
            this.head = this.tail = null;
            this.size--;
            return val;
        }
        int val = this.tail.val;
        this.tail = this.tail.left;
        this.tail.right = null;
        this.size--;
        return val;
    }

    public int popleft() {
        if (this.head == null) return -1;
        else if (this.size == 1) {
            int val = this.head.val;
            this.head = this.tail = null;
            this.size--;
            return val;
        }
        int val = this.head.val;
        this.head = this.head.right;
        this.head.left = null;
        this.size--;
        return val;
    }
}
