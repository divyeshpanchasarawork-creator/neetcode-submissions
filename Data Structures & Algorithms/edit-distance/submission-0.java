class Solution {
    public int minDistance(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        int m = arr1.length;
        int n = arr2.length;

        int[][] dp = new int[m + 1][n + 1];

        for (int j = 0; j <= n; j++) {
            dp[m][j] = n - j;
        }

        for (int i = m - 1; i >= 0; i--) {
            dp[i][n] = m - i;
            for (int j = n - 1; j >= 0; j--) {
                if (arr1[i] == arr2[j]) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    int insert = dp[i][j + 1];
                    int delete = dp[i + 1][j];
                    int replace = dp[i + 1][j + 1];

                    dp[i][j] = 1 + Math.min(
                        insert,
                        Math.min(
                            delete,
                            replace
                        )
                    );
                }
            }
        }

        return dp[0][0];
    }
}
