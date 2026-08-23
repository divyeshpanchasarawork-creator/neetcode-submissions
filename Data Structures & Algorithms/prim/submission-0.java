class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        List<int[]>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);

            adjList[u].add(new int[] {v, w});
            adjList[v].add(new int[] {u, w});
        }

        List<int[]> mst = new ArrayList<>();

        Queue<int[]> pq = new PriorityQueue<>(
            (a, b) -> { 
                return Integer.compare(a[2], b[2]); 
            }
        );

        pq.offer(new int[] {-1, 0, 0});

        boolean[] visited = new boolean[n];

        while (!pq.isEmpty()) {
            int[] arr = pq.poll();

            int currNode = arr[1];
            int currWt = arr[2];

            if (visited[currNode]) {
                continue;
            }
            
            if (arr[0] != -1) mst.add(arr);

            visited[currNode] = true;

            for (int[] neighbor : adjList[currNode]) {
                int neigh = neighbor[0];
                int wt = neighbor[1];

                if (!visited[neigh]) {
                    pq.offer(new int[]{currNode, neigh, wt});
                }
            }
        }

        if (mst.size() < n - 1)
            return -1;

        int ans = 0;

        for (int[] edge : mst) {
            ans += edge[2];
        }

        return ans;
    }
}
