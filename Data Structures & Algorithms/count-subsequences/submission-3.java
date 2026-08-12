class Solution {
    public int numDistinct(String s, String t) {
        char[] src = s.toCharArray();
        char[] target = t.toCharArray();

        int m = src.length;
        int n = target.length;

        int[][] dp = new int[m + 1][n + 1];
        dp[m][n] = 1;
        
        for (int i = m - 1; i >= 0; i--) {
            dp[i][n] = 1;
            for (int j = n - 1; j >= 0; j--) {
                int ans = 0;
                if (src[i] == target[j]) {
                    ans += dp[i + 1][j + 1];
                }

                ans += dp[i + 1][j];

                dp[i][j] = ans;
            }
        }
        
        return dp[0][0];
    }
}
