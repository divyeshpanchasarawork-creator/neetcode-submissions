class Solution {
    private class MinHeap {
        private class Point {
            private int[] p;
            double rad;

            public Point(int[] p) {
                this.p = new int[2];
                this.p[0] = p[0];
                this.p[1] = p[1];
                this.rad = Math.sqrt(p[0] * p[0] + p[1] * p[1]);
            }

            public int[] toArray() {
                return this.p;
            }
        }

        private final List<Point> heap;
        private int size;

        public MinHeap() {
            this.heap = new ArrayList<>();
            heap.add(null);
        }

        public void push(int[] p) {
            heap.add(new Point(p));

            this.size++;

            int i = this.size;

            while (i > 1) {
                if (heap.get(i).rad < heap.get(i / 2).rad)
                    swap(heap, i, i / 2);
                else
                    break;
                i /= 2;
            }
        }

        public int[] pop() {
            if (this.size == 0)
                return null;
            if (this.size == 1) {
                this.size--;
                return heap.removeLast().toArray();
            }

            Point p = heap.get(1);
            heap.set(1, heap.removeLast());
            int i = 1;

            while (2 * i < this.size) {
                boolean hasRight = 2 * i + 1 < this.size;
                if (hasRight && heap.get(2 * i + 1).rad < heap.get(2 * i).rad
                        && heap.get(2 * i + 1).rad < heap.get(i).rad) {
                    swap(heap, i, 2 * i + 1);
                    i = 2 * i + 1;
                } else if (heap.get(2 * i).rad < heap.get(i).rad) {
                    swap(heap, i, 2 * i);
                    i *= 2;
                } else
                    break;
            }

            this.size--;
            return p.toArray();
        }

        private void swap(List<Point> pts, int i, int j) {
            Point p = pts.get(i);
            pts.set(i, pts.get(j));
            pts.set(j, p);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        MinHeap heap = new MinHeap();
        for (int[] p : points)
            heap.push(p);
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++)
            ans[i] = heap.pop();
        return ans;
    }
}