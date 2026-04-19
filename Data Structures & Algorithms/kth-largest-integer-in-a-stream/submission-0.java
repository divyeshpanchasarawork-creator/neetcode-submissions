class KthLargest {
    class MinHeap {
        private final List<Integer> heap;
        private int size;

        public MinHeap() {
            heap = new ArrayList<>();
            heap.add(0);
        }

        public void push(int e) {
            this.size++;
            heap.add(e);

            int i = heap.size() - 1;

            while (i > 1) {
                if (heap.get(i) < heap.get(i / 2))
                    swap(heap, i, i / 2);
                else
                    break;
                i /= 2;
            }
        }

        public int pop() {
            if (this.size == 0)
                return -1;
            if (this.size == 1) {
                this.size--;
                return heap.removeLast();
            }

            int ele = heap.get(1);
            heap.set(1, heap.removeLast());
            int i = 1;
            while (2 * i < this.size) {
                boolean hasRight = 2 * i + 1 < this.size;

                if (hasRight && heap.get(2 * i + 1) < heap.get(2 * i)
                    && heap.get(i) > heap.get(2 * i + 1)) {
                    swap(heap, i, 2 * i + 1);
                    i = 2 * i + 1;
                } else if (heap.get(i) > heap.get(2 * i)) {
                    swap(heap, i, 2 * i);
                    i *= 2;
                } else
                    break;
            }
            this.size--;
            return ele;
        }

        private void swap(List<Integer> list, int i, int j) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }

        private int getSize() {
            return this.size;
        }

        private int peek() {
            return heap.get(1);
        }
    }

    private final MinHeap heap = new MinHeap();
    private final int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) heap.push(num);
        while (heap.getSize() > k) heap.pop();
    }

    public int add(int val) {
        heap.push(val);
        if (heap.getSize() > k) heap.pop();
        return heap.peek();
    }
}
