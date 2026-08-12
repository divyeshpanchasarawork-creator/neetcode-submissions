class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        char[] arr3 = s3.toCharArray();

        Boolean[][] memo = new Boolean[arr1.length + 1][arr2.length + 1];

        return solve(0, 0, arr1, arr2, arr3, memo);
    }

    private boolean solve(int i, int j, char[] arr1, char[] arr2, char[] arr3, Boolean[][] memo) {
        if (i + j >= arr3.length) return true;

        if (memo[i][j] != null) return memo[i][j];

        boolean ans = false;

        if (i < arr1.length && arr1[i] == arr3[i + j]) {
            ans |= solve(i + 1, j, arr1, arr2, arr3, memo);
        }

        if (j < arr2.length && arr2[j] == arr3[i + j]) {
            ans |= solve(i, j + 1, arr1, arr2, arr3, memo);
        }

        return memo[i][j] = ans;
    }
}
