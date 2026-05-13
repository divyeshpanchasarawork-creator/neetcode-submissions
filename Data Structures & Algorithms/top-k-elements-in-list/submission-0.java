class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int e: nums) map.put(e, map.getOrDefault(e, 0) + 1);

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int key: map.keySet()) pq.offer(new int[]{key, map.get(key)});

        int[] result = new int[k];

        while (k-- > 0) {
            int[] arr = pq.poll();
            result[k] = arr[0];
        }

        return result;
    }
}
