class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int target = image[sr][sc];

        if (target == color) return image;

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{sr, sc});

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] p = queue.poll();

                image[p[0]][p[1]] = color;

                for (int[] d: directions) {
                    int x = p[0] + d[0];
                    int y = p[1] + d[1];

                    if (x >= 0 && x < image.length
                            && y >= 0 && y < image[0].length
                            && image[x][y] == target) queue.offer(new int[]{x, y});
                }
            }
        }

        return image;
    }
}