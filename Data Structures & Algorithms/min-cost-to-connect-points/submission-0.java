class Solution {
    public int minCostConnectPoints(int[][] points) {
        if (1 == points.length) return 0;

        List<int[]>[] adjList = buildGraph(points);

        int n = adjList.length;

        Queue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                return Integer.compare(a[2], b[2]);
            }
        );

        pq.offer(new int[]{-1, 0, 0});

        boolean[] visited = new boolean[n];

        int ans = 0;

        while (!pq.isEmpty()) {
            int[] arr = pq.poll();

            int parent = arr[0];
            int currNode = arr[1];
            int currWt = arr[2];

            if (visited[currNode]) continue;

            visited[currNode] = true;

            ans += currWt;

            for (int[] neigh : adjList[currNode]) {
                if (!visited[neigh[0]]) {
                    pq.offer(new int[]{currNode, neigh[0], neigh[1]});
                }
            }
        }

        return ans;
    }

    private List<int[]>[] buildGraph(int[][] points) {
        int n = points.length;

        List<int[]>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int r = getDistance(points[i], points[j]);

                adjList[i].add(new int[]{j, r});
                adjList[j].add(new int[]{i, r});
            }
        }

        return adjList;
    }

    private int getDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
