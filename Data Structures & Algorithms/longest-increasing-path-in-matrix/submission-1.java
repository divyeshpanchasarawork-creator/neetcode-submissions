class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] memo = new int[m][n];
        for (int[] r : memo) Arrays.fill(r, -1);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans = Math.max(ans, solve(i, j, matrix, memo));
            }
        }

        return ans;
    }

    private int solve(int i, int j, int[][] grid, int[][] memo) {
        int up = 0;
        int right = 0;
        int down = 0;
        int left = 0;

        if (memo[i][j] != -1) return memo[i][j];

        if (i - 1 >= 0 && grid[i][j] < grid[i - 1][j]) {
            up = solve(i - 1, j, grid, memo);
        }

        if (j + 1 < grid[0].length && grid[i][j] < grid[i][j + 1]) {
            right = solve(i, j + 1, grid, memo);
        }

        if (i + 1 < grid.length && grid[i][j] < grid[i + 1][j]) {
            down = solve(i + 1, j, grid, memo);
        }

        if (j - 1 >= 0 && grid[i][j] < grid[i][j - 1]) {
            left = solve(i, j - 1, grid, memo);
        }

        return memo[i][j] = 1 + Math.max(
            Math.max(up, right),
            Math.max(down, left)
        );
    }
}
