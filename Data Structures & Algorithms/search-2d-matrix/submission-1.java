class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;

        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;

            if (matrix[mid][0] > target) bottom = mid - 1;
            else top = mid + 1;
        }

        if (bottom < 0) return false;

        int l = 0;
        int r = matrix[0].length - 1;
        
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (matrix[bottom][mid] == target) return true;
            else if (matrix[bottom][mid] > target) r = mid - 1;
            else l = mid + 1;
        }

        return false;
    }
}