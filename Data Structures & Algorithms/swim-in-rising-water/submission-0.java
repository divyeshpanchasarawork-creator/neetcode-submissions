class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        minHeap.offer(new int[] { 0, 0, grid[0][0] });

        int ans = grid[0][0];

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();

            ans = Math.max(ans, curr[2]);
            grid[curr[0]][curr[1]] = -1;

            if (curr[0] == n - 1 && curr[1] == n - 1)
                break;

            for (int[] d : directions) {
                int x = curr[0] + d[0];
                int y = curr[1] + d[1];

                if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] != -1)
                    minHeap.offer(new int[] { x, y, grid[x][y] });
            }
        }

        return ans;
    }
}