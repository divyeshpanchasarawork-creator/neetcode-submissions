class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int rows = heights.length;
        int cols = heights[0].length;

        Queue<int[]> pacificQueue = new ArrayDeque<>();
        Queue<int[]> atlanticQueue = new ArrayDeque<>();

        boolean[][] pacificReachable = new boolean[rows][cols];
        boolean[][] atlanticReachable = new boolean[rows][cols];

        for (int j = 0; j < cols; j++) {
            pacificQueue.offer(new int[]{0, j});
            pacificReachable[0][j] = true;

            atlanticQueue.offer(new int[]{rows - 1, j});
            atlanticReachable[rows - 1][j] = true;
        }

        for (int i = 0; i < rows; i++) {
            if (!pacificReachable[i][0]) {
                pacificQueue.offer(new int[]{i, 0});
                pacificReachable[i][0] = true;
            }

            if (!atlanticReachable[i][cols - 1]) {
                atlanticQueue.offer(new int[]{i, cols - 1});
                atlanticReachable[i][cols - 1] = true;
            }
        }

        bfs(heights, pacificQueue, pacificReachable);
        bfs(heights, atlanticQueue, atlanticReachable);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void bfs(int[][] grid, Queue<int[]> q, boolean[][] reachable) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] directions = {0, 1, 0, -1, 0};

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int currX = p[0];
            int currY = p[1];

            for (int d = 0; d < 4; d++) {
                int x = currX + directions[d];
                int y = currY + directions[d + 1];

                if (x < 0 || y < 0 || x >= rows || y >= cols || reachable[x][y]) {
                    continue;
                }

                if (grid[x][y] >= grid[currX][currY]) {
                    reachable[x][y] = true;
                    q.offer(new int[]{x, y});
                }
            }
        }
    }
}