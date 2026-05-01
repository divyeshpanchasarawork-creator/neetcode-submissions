class Solution {
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return dfs(i, j, grid);
            }
        }

        return 0;
    }

    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 1;

        if (grid[i][j] == -1) return 0;

        grid[i][j] = -1;

        int a = dfs(i, j + 1, grid);
        int b = dfs(i, j - 1, grid);
        int c = dfs(i + 1, j, grid);
        int d = dfs(i - 1, j, grid);

        return a + b + c + d;
    }
}