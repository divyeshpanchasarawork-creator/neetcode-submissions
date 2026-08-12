class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        char[] arr3 = s3.toCharArray();

        int m = arr1.length;
        int n = arr2.length;

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[m][n] = true;

        for (int j = n - 1; j >= 0; j--) {
            dp[m][j] = (arr2[j] == arr3[m + j]) && dp[m][j + 1];
        }

        for (int i = m - 1; i >= 0; i--) {
            dp[i][n] = (arr1[i] == arr3[i + n]) && dp[i + 1][n];
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                boolean ans = false;

                if (arr1[i] == arr3[i + j]) ans |= dp[i + 1][j];
                if (arr2[j] == arr3[i + j]) ans |= dp[i][j + 1];

                dp[i][j] = ans;
            }
        }

        return dp[0][0];
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
