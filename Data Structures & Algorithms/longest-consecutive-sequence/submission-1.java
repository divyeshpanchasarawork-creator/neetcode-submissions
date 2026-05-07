class Solution {
    public class DSU {
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
            if (parent.containsKey(n - 1)) union(n, n - 1);
            if (parent.containsKey(n + 1)) union(n, n + 1);
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

        public int longestConsecutive() {
            int maxCon = 1;
            Map<Integer, Integer> map = new HashMap<>();
            for (int n: parent.keySet()) {
                int root = this.find(n);
                map.put(root, map.getOrDefault(root, 0) + 1);
                maxCon = Math.max(maxCon, map.get(root));
            }
            return maxCon;
        }
    }
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        DSU dsu = new DSU();
        for (int e: nums) dsu.addNode(e);
        return dsu.longestConsecutive();
    }
}
