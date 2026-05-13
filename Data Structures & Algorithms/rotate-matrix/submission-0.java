class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        transpose(matrix, n);
        for (int[] r: matrix) reverse(r, n);
    }

    private void transpose(int[][] m, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(i, j, m);
            }
        }
    }

    private void swap(int i, int j, int[][] m) {
        int t = m[i][j];
        m[i][j] = m[j][i];
        m[j][i] = t;
    }

    private void reverse(int[] row, int n) {
        int l = 0;
        int r = n - 1;

        while (l < r) swap(l++, r--, row);
    }

    private void swap(int l, int r, int[] arr) {
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }
}
