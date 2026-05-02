class NumMatrix {
    private final int[][] prefix;
    public NumMatrix(int[][] matrix) {
        for (int[] r: matrix) {
            for (int i = 1; i < r.length; i++) r[i] += r[i - 1];
        }
        prefix = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            if (col1 == 0) sum += prefix[i][col2];
            else sum += (prefix[i][col2] - prefix[i][col1 - 1]);
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */