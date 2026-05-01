class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(sr, sc, image[sr][sc], color, image);
        return image;
    }

    private void dfs(int i, int j, int target, int color, int[][] img) {
        if (i < 0 || i >= img.length || j < 0 || j >= img[0].length) return;

        if (img[i][j] == color || img[i][j] != target) return;

        img[i][j] = color;
        
        dfs(i, j + 1, target, color, img);
        dfs(i, j - 1, target, color, img);
        dfs(i + 1, j, target, color, img);
        dfs(i - 1, j, target, color, img);
    }
}