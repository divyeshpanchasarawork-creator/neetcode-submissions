class KthLargest {
    private final PriorityQueue<Integer> pq;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        for (int e: nums) pq.offer(e);
        while (pq.size() > k) pq.poll();
    }
    
    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) pq.poll();
        return pq.peek();
    }
}
