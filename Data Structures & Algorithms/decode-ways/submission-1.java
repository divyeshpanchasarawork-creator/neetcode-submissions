class Solution {
    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == '0') {
                dp[i] = 0;
                continue;
            }

            dp[i] += dp[i + 1];

            if (i + 1 < n) {
                int twoDig = (arr[i] - '0') * 10 + (arr[i + 1] - '0');
                if (twoDig >= 10 && twoDig <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }

        return dp[0];
    }
}
