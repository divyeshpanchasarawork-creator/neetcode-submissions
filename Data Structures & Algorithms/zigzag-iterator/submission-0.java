class ZigzagIterator {
    private List<Integer> list;
    private int curr;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new ArrayList<>();

        int i = 0;
        int j = 0;
        boolean one = true;
        while (i < v1.size() && j < v2.size()) {
            if (one) list.add(v1.get(i++));
            else list.add(v2.get(j++));
            one = !one;
        }

        while (i < v1.size()) list.add(v1.get(i++));
        
        while (j < v2.size()) list.add(v2.get(j++));
    }

    public int next() {
        return list.get(curr++);
    }

    public boolean hasNext() {
        return curr < list.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
