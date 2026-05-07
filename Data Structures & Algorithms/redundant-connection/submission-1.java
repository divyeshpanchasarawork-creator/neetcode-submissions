class Solution {
    private class DSU {
        private final Map<Integer, Integer> parent;
        private final Map<Integer, Integer> rank;

        public DSU() {
            parent = new HashMap<>();
            rank = new HashMap<>();
        }

        private void addNode(int n) {
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

            int rankX = rank.get(x);
            int rankY = rank.get(y);

            if (parentX == parentY)
                return false;

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

        public int[] buildDSU(int[][] edges) {
            int[] ans = null;
            for (int[] e : edges) {
                this.addNode(e[0]);
                this.addNode(e[1]);
                if (!this.union(e[0], e[1]))
                    ans = e;
            }
            return ans;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU();
        return dsu.buildDSU(edges);
    }
}
