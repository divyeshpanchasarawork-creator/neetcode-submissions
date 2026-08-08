class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] count = new int[strs.length][2];

        for (int i = 0; i < strs.length; i++) {
            for (char ch : strs[i].toCharArray()) {
                if (ch == '0') {
                    count[i][0]++;
                } else count[i][1]++;
            }
        }

        int[][][] dp = new int[strs.length][m + 1][n + 1];

        for (int[][] d : dp) {
            for (int[] arr: d) Arrays.fill(arr, -1);
        }

        return solve(0, count, m, n, dp);
    }

    private int solve(int i, int[][] count, int m, int n, int[][][] dp) {
        if (i >= count.length) return 0;

        if (dp[i][m][n] != -1) return dp[i][m][n];

        int skip = solve(i + 1, count, m, n, dp);

        int pick = 0;

        if (count[i][0] <= m && count[i][1] <= n) {
            pick = 1 + solve(
                i + 1,
                count,
                m - count[i][0],
                n - count[i][1],
                dp
            );
        }

        dp[i][m][n] = Math.max(skip, pick);

        return dp[i][m][n];
    }
}