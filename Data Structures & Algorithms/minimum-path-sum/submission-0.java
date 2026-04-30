class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] memo = new int[m][n];
        for(int[] r: memo) Arrays.fill(r, -1);

        return helper(0, 0, m, n, grid, memo);
    }

    private int helper(int i, int j, int m, int n, int[][] grid, int[][] memo) {
        if (i == m || j == n ) return Integer.MAX_VALUE;

        if (i == m - 1 && j == n - 1) return grid[i][j];
        if (memo[i][j] != -1) return memo[i][j];

        int pick = grid[i][j];
        int right = helper(i, j + 1, m, n, grid, memo);
        int down = helper(i + 1, j, m, n, grid, memo);

        memo[i][j] = pick + Math.min(right, down);

        return memo[i][j];
    }
}