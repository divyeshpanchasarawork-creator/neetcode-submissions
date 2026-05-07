class Solution {
    private class DSU {
        private final Map<Integer, Integer> parent;
        private final Map<Integer, Integer> rank;

        public DSU() {
            parent = new HashMap<>();
            rank = new HashMap<>();
        }

        public void addNode(int n) {
            if (parent.containsKey(n))
                return;
            parent.put(n, n);
            rank.put(n, 0);
        }

        public int find(int n) {
            while (parent.get(n) != n) {
                parent.put(n, parent.get(parent.get(n)));
                n = parent.get(n);
            }
            return n;
        }

        public boolean union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);

            if (parentX == parentY)
                return false;

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

            return true;
        }

        public void buildDSU(int[][] edges) {
            for (int[] e : edges) {
                this.addNode(e[0]);
                this.addNode(e[1]);
                this.union(e[0], e[1]);
            }
        }

        private int getUniqueRoots() {
            Set<Integer> set = new HashSet<>();
            for (int k : parent.keySet()) {
                set.add(find(k));
            }
            return set.size();
        }
    }

    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU();
        for (int i = 0; i < n; i++) dsu.addNode(i);
        dsu.buildDSU(edges);
        return dsu.getUniqueRoots();
    }
}
