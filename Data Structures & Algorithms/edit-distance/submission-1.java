class Solution {
    public int minDistance(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        int m = arr1.length;
        int n = arr2.length;

        int[] dp = new int[n + 1];

        for (int j = 0; j <= n; j++) {
            dp[j] = n - j;
        }

        for (int i = m - 1; i >= 0; i--) {
            int[] curr = new int[n + 1];
            curr[n] = m - i;

            for (int j = n - 1; j >= 0; j--) {
                if (arr1[i] == arr2[j]) {
                    curr[j] = dp[j + 1];
                } else {
                    int insert = curr[j + 1];
                    int delete = dp[j];
                    int replace = dp[j + 1];

                    curr[j] = 1 + Math.min(
                        insert,
                        Math.min(
                            delete,
                            replace
                        )
                    );
                }
            }
            dp = curr;
        }

        return dp[0];
    }
}
