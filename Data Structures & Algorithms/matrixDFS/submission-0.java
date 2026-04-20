class Solution {
    public int countPaths(int[][] grid) {
        return helper(grid, 0, 0);
    }

    private int helper(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 1)
            return 0;

        if (i == grid.length - 1 && j == grid[0].length - 1) return 1;

        grid[i][j] = 1;

        int up = helper(grid, i - 1, j);
        int down = helper(grid, i + 1, j);
        int left = helper(grid, i, j - 1);
        int right = helper(grid, i, j + 1);

        grid[i][j] = 0;

        return up + down + left + right;
    }
}
