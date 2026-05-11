class MedianFinder {
    private final Queue<Integer> minHeap;
    private final Queue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    }

    public void addNum(int num) {
        maxHeap.offer(num);

        if ((!minHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) || (maxHeap.size() > minHeap.size() + 1)) {
            minHeap.offer(maxHeap.poll());
        }

        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size())
            return (double) (minHeap.peek());
        else if (maxHeap.size() > minHeap.size())
            return (double) (maxHeap.peek());

        return (double) (minHeap.peek() + maxHeap.peek()) / 2;
    }
}
