class Solution {
    public int shortestPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (n == 1 && m == 1 && grid[0][0] == 0) return 0;

        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return -1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int len = 0;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] p = queue.remove();

                for (int[] d: directions) {
                    int x = p[0] + d[0];
                    int y = p[1] + d[1];

                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 1) continue;

                    if (x == m - 1 && y == n - 1) return len + 1;

                    grid[x][y] = 1;
                    queue.offer(new int[]{x, y});
                }
            }
            len++;
        }

        return -1;
    }
}
