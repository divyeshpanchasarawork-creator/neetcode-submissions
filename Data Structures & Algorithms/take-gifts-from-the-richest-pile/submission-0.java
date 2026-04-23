class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int e: gifts) maxHeap.offer(e);

        while (k-- > 0) {
            int val = maxHeap.poll();
            maxHeap.offer((int)(Math.sqrt(val)));
        }

        int ans = 0;
        while (!maxHeap.isEmpty()) ans += maxHeap.poll();
        return ans;
    }
}