class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Integer[]>> adjList = new HashMap<>();

        for (int i = 1; i <= n; i++) adjList.put(i, new ArrayList<>());

        for (int[] e: times) {
            adjList.get(e[0]).add(new Integer[]{e[1], e[2]});
        }

        Map<Integer, Integer> costMap = new HashMap<>();

        Queue<Integer[]> minHeap = new PriorityQueue<>((n1, n2) -> (n1[0] - n2[0]));

        minHeap.offer(new Integer[]{0, k});

        while (!minHeap.isEmpty()) {
            Integer[] curr = minHeap.poll();

            int n1 = curr[1];
            int w1 = curr[0];

            if (costMap.containsKey(n1)) continue;

            costMap.put(n1, w1);

            for (Integer[] neighbour: adjList.get(n1)) {
                int n2 = neighbour[0];
                int w2 = neighbour[1];

                if (!costMap.containsKey(n2)) {
                    minHeap.offer(new Integer[]{w1 + w2, n2});
                }
            }
        }

        if (costMap.size() < n) return -1;

        int ans = Integer.MIN_VALUE;

        for (int key: costMap.keySet()) ans = Math.max(ans, costMap.get(key));

        return ans; 
    }
}
