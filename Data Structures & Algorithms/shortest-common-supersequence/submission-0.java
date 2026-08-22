class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        int[][] dp = buildTable(arr1, arr2);
        StringBuilder sb = new StringBuilder();

        int i = 0;
        int j = 0;

        int m = dp.length - 1;
        int n = dp[0].length - 1;

        while (i < m && j < n) {
            if (arr1[i] == arr2[j]) {
                sb.append(arr1[i]);
                i++;
                j++;
            } else if (dp[i + 1][j] <= dp[i][j + 1]) {
                sb.append(arr1[i]);
                i++;
            } else {
                sb.append(arr2[j]);
                j++;
            }
        }

        sb.append(str1.substring(i));
        sb.append(str2.substring(j));

        return sb.toString();
    }

    private int[][] buildTable(char[] arr1, char[] arr2) {
        int m = arr1.length;
        int n = arr2.length;

        int[][] dp = new int[m + 1][n + 1];

        for (int j = 0; j <= n; j++) {
            dp[m][j] = n - j;
        }

        for (int i = 0; i <= m; i++) {
            dp[i][n] = m - i;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (arr1[i] == arr2[j]) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                        dp[i + 1][j],
                        dp[i][j + 1]
                    );
                }
            }
        }

        return dp;
    }
}