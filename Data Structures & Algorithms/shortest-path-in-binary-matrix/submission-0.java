class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (n == 1 && grid[0][0] == 0) return 1;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        int len = 1;
        
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] p = queue.remove();
                for (int[] d: directions) {
                    int x = p[0] + d[0];
                    int y = p[1] + d[1];

                    if (x < 0 || y < 0 || x >= n || y >= n || grid[x][y] == 1) continue;

                    if (x == n - 1 && y == n - 1) return len + 1;

                    grid[x][y] = 1;
                    queue.offer(new int[]{x, y});
                }
            }

            len++;
        }

        return -1;   
    }
}