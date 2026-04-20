class MinHeap {
    private List<Integer> heap;
    private int size;
    public MinHeap() {
        this.heap = new ArrayList<>();
        heap.add(0);
    }

    public void push(int val) {
        heap.add(val);
        this.size++;

        int i = this.size;

        while (i > 1) {
            if (heap.get(i) < heap.get(i / 2))
                swap(heap, i, i / 2);
            else
                break;
            i /= 2;
        }
    }

    public Integer pop() {
        if (this.size == 0)
            return -1;
        else if (this.size == 1) {
            this.size--;
            return heap.removeLast();
        }

        int top = heap.get(1);
        heap.set(1, heap.removeLast());
        int i = 1;

        while (2 * i < this.size) {
            boolean hasRight = 2 * i + 1 < this.size;

            if (hasRight && heap.get(2 * i + 1) < heap.get(2 * i)
                && heap.get(2 * i + 1) < heap.get(i)) {
                swap(heap, 2 * i + 1, i);
                i = 2 * i + 1;
            } else if (heap.get(2 * i) < heap.get(i)) {
                swap(heap, i, 2 * i);
                i *= 2;
            } else
                break;
        }

        this.size--;
        return top;
    }

    public Integer top() {
        if (this.size == 0)
            return -1;
        return heap.get(1);
    }

    private void swap(List<Integer> l, int i, int j) {
        int t = l.get(i);
        l.set(i, l.get(j));
        l.set(j, t);
    }

    public void heapify(List<Integer> arr) {
        this.heap = new ArrayList<>();
        this.heap.add(0);
        this.heap.addAll(arr);
        this.size = arr.size();

        for (int i = this.size / 2; i >= 1; i--) {
            siftDown(i);
        }
    }

    private void siftDown(int i) {
        while (2 * i <= this.size) {
            boolean hasRight = 2 * i + 1 <= this.size;

            if (hasRight && heap.get(2 * i + 1) < heap.get(2 * i)
                && heap.get(2 * i + 1) < heap.get(i)) {
                swap(heap, 2 * i + 1, i);
                i = 2 * i + 1;
            } else if (heap.get(2 * i) < heap.get(i)) {
                swap(heap, i, 2 * i);
                i *= 2;
            } else {
                break;
            }
        }
    }
}
