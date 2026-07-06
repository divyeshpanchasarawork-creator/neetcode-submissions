class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for (int i = 0; i < n; i++)
            adjList.put(i, new ArrayList<>());

        for (int[] f : flights)
            adjList.get(f[0]).add(new int[] { f[1], f[2], 0 });

        Queue<int[]> queue = new PriorityQueue<>(
                (a, b) -> {
                    if (a[1] == b[1])
                        return a[2] - b[2];
                    return a[1] - b[1];
                });

        Map<Integer, List<int[]>> map = new HashMap<>();

        queue.offer(new int[] { src, 0, 0 });

        int[][] minCost = new int[n][k + 2];
        for (int[] row : minCost)
            Arrays.fill(row, Integer.MAX_VALUE);
        minCost[src][0] = 0;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();

            int n1 = arr[0];
            int u1 = arr[1];
            int k1 = arr[2];

            if (k1 > k + 1) {
                continue;
            }

            map.putIfAbsent(n1, new ArrayList<>());
            map.get(n1).add(new int[] { u1, k1 });

            if (n1 == dst) {
                continue;
            }

            for (int[] next : adjList.get(n1)) {
                int n2 = next[0];
                int u2 = next[1];
                int newStops = k1 + 1;
                int newCost = u1 + u2;

                if (newStops <= k + 1 && newCost < minCost[n2][newStops]) {
                    minCost[n2][newStops] = newCost;
                    queue.offer(new int[] { n2, newCost, newStops });
                }
            }
        }

        if (!map.containsKey(dst))
            return -1;

        int ans = Integer.MAX_VALUE;
        for (int s = 0; s <= k + 1; s++)
            ans = Math.min(ans, minCost[dst][s]);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}