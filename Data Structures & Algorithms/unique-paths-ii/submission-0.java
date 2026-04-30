class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[m - 1][n - 1] == 1) return 0;

        int[][] memo = new int[m][n];

        for (int[] r: memo) Arrays.fill(r, -1);

        return helper(0, 0, m, n, memo, grid);
    }

    private int helper(int i, int j, int m, int n, int[][] memo, int[][] grid) {
        if (i == m || j == n || grid[i][j] == 1) return 0;
    
        if (i == m - 1 && j == n - 1) return 1;
        if (memo[i][j] != -1) return memo[i][j];

        int right = helper(i, j + 1, m, n, memo, grid);
        int down = helper(i + 1, j, m, n, memo, grid);

        memo[i][j] = right + down;

        return memo[i][j];
    }
}