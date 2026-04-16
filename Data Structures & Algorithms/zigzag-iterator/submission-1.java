class ZigzagIterator {
    private boolean turn;
    private List<Integer> l1;
    private List<Integer> l2;
    private int i;
    private int j;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.l1 = v1;
        this.l2 = v2;
        this.turn = v1.isEmpty() ? false : true;
        this.i = this.j = 0;    
    }

    public int next() {
        if (!hasNext()) return -1;
        if (turn) {
            int val = l1.get(i++);
            if (j < l2.size()) turn = !turn;
            return val;
        } else {
            int val = l2.get(j++);
            if (i < l1.size()) turn = !turn;
            return val;
        }
    }

    public boolean hasNext() {
        return i + j < l1.size() + l2.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
