class UnionFind {
    private final Map<Integer, Integer> parent;
    private final Map<Integer, Integer> rank;
    private int components;

    public UnionFind(int n) {
        parent = new HashMap<>();
        rank = new HashMap<>();
        components = n;
        for (int i = 0; i < n; i++) {
            addNode(i);
        }
    }

    public int find(int n) {
        while (parent.get(n) != n) {
            parent.put(n, parent.get(parent.get(n)));
            n = parent.get(n);
        }

        return n;
    }

    public boolean isSameComponent(int x, int y) {
        return find(x) == find(y);
    }

    private void addNode(int n) {
        if (parent.containsKey(n)) return;
        parent.put(n, n);
        rank.put(n, 0);
    }

    public boolean union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX == parentY) return false;

        int rankX = rank.get(parentX);
        int rankY = rank.get(parentY);

        if (rankX < rankY) {
            parent.put(parentX, parentY);
        } else if (rankX > rankY) {
            parent.put(parentY, parentX);
        } else {
            parent.put(parentX, parentY);
            rank.put(parentY, rankY + 1);
        }

        components--;
        return true;
    }

    public int getNumComponents() {
        return components;
    }
}
