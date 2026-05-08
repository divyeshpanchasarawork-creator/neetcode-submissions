class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int s) {
        Map<Integer, List<Integer[]>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) adjList.put(i, new ArrayList<>());

        for (List<Integer> e: edges) {
            Integer src = e.get(0);
            Integer dst = e.get(1);
            Integer cost = e.get(2);

            List<Integer[]> neighbours = adjList.get(src);
            neighbours.add(new Integer[]{dst, cost});
        }

        Map<Integer, Integer> costMap = new HashMap<>();

        Queue<Integer[]> minHeap = new PriorityQueue<>((n1, n2) -> (n1[0] - n2[0]));

        minHeap.offer(new Integer[]{0, s});

        while (!minHeap.isEmpty()) {
            Integer[] curr = minHeap.remove();

            Integer w1 = curr[0];
            Integer n1 = curr[1];

            if (costMap.containsKey(n1)) continue;

            costMap.put(n1, w1);

            for (Integer[] nearest: adjList.get(n1)) {
                Integer n2 = nearest[0];
                Integer w2 = nearest[1];

                if (!costMap.containsKey(n2)) {
                    minHeap.offer(new Integer[]{w1 + w2, n2});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!costMap.containsKey(i)) costMap.put(i, -1);
        }

        return costMap;
    }  
}
