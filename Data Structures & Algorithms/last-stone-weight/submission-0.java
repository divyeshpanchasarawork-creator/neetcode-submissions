class Solution {
    public class MaxHeap {
        private final List<Integer> heap;
        private int size;

        public MaxHeap() {
            heap = new ArrayList<>();
            heap.add(0);
        }

        public void push(int e) {
            heap.add(e);
            this.size++;
            int i = heap.size() - 1;

            while (i > 1) {
                if (heap.get(i) > heap.get(i / 2))
                    swap(heap, i, i / 2);
                else
                    break;
                i /= 2;
            }
        }

        private void swap(List<Integer> l, int i, int j) {
            int temp = l.get(i);
            l.set(i, l.get(j));
            l.set(j, temp);
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

                if (hasRight && heap.get(2 * i + 1) > heap.get(2 * i)
                    && heap.get(i) < heap.get(2 * i + 1)) {
                    swap(heap, i, 2 * i + 1);
                    i = 2 * i + 1;
                } else if (heap.get(i) < heap.get(2 * i)) {
                    swap(heap, i, 2 * i);
                    i *= 2;
                } else
                    break;
            }
            this.size--;
            return ele;
        }

        public int getSize() {
            return this.size;
        }

        public int peek() {
            return heap.get(1);
        }

        private boolean isEmpty() {
            return this.size == 0;
        }
    }
    public int lastStoneWeight(int[] stones) {
        final MaxHeap heap = new MaxHeap();
        for (int e: stones) heap.push(e);
        int y = heap.pop();
        while (!heap.isEmpty()) {
            int x = heap.peek();
            if (x == y) {
                heap.pop();
                y = heap.pop();
            }
            else {
                int newStone = y - x;
                heap.pop();
                heap.push(newStone);
                y = heap.pop();
            }
        }

        return y < 0 ? 0 : y;
    }
}
