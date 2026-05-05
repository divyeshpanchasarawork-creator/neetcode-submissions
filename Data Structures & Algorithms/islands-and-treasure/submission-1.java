class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] p = queue.poll();

                if (grid[p[0]][p[1]] == Integer.MAX_VALUE) grid[p[0]][p[1]] = level;

                for (int[] d: directions) {
                    int x = p[0] + d[0];
                    int y = p[1] + d[1];

                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == Integer.MAX_VALUE) {
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            level++;
        }
    }
}
