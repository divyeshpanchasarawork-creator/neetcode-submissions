class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    setZeroDFS(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void setZeroDFS(char[][] g, int i, int j) {
        if (i < 0 || i >= g.length || j < 0 || j >= g[0].length || g[i][j] == '0') return;

        g[i][j] = '0';

        setZeroDFS(g, i - 1, j);
        setZeroDFS(g, i + 1, j);
        setZeroDFS(g, i, j - 1);
        setZeroDFS(g, i, j + 1);
    }
}
