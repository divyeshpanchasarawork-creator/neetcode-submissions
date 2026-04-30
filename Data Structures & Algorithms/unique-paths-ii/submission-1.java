class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[m - 1][n - 1] == 1) return 0;

        int[][] memo = new int[m][n];

        for (int[] r: memo) Arrays.fill(r, -1);

        return helper(m - 1, n - 1, memo, grid);
    }

    private int helper(int m, int n, int[][] memo, int[][] grid) {
        if (m < 0 || n < 0 || grid[m][n] == 1) return 0;
    
        if (m == 0 && n == 0) return 1;
        if (memo[m][n] != -1) return memo[m][n];

        int right = helper(m, n - 1, memo, grid);
        int down = helper(m - 1, n, memo, grid);

        memo[m][n] = right + down;

        return memo[m][n];
    }
}