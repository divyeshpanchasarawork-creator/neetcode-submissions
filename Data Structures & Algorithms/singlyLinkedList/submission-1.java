class LinkedList {

    class Node {
        int val;
        Node next;

        Node (int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {

    }

    public int get(int index) {
        if (index < 0 || index >= this.size) return -1;
        
        Node curr = this.head;

        while (index-- > 0) curr = curr.next;

        return curr.val;
    }

    public void insertHead(int val) {
        Node node = new Node(val);
        this.size++;
        if (this.head == null) {
            this.head = this.tail = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }

    public void insertTail(int val) {
        if (this.head == null) {
            insertHead(val);
            return;
        }
        Node node = new Node(val);
        this.tail.next = node;
        this.tail = node;
        this.size++;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) return false;

        if (index == 0) {
            head = head.next;
            size--;
            if (size == 0) tail = null;
            return true;
        }

        Node curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        
        curr.next = curr.next.next;
        
        if (index == size - 1) {
            tail = curr;
        }

        size--;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();

        if (this.size <= 0) return values;

        Node curr = this.head;

        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }

        return values;
    }
}
