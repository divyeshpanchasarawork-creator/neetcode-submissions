class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, calArea(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    private int calArea(int[][] g, int i, int j) {
        if (i < 0 || i >= g.length || j < 0 || j >= g[0].length || g[i][j] == 0) return 0;

        g[i][j] = 0;
        int area = 1;
        area += calArea(g, i - 1, j);
        area += calArea(g, i, j + 1);
        area += calArea(g, i + 1, j);
        area += calArea(g, i, j - 1);

        return area;
    }
}
