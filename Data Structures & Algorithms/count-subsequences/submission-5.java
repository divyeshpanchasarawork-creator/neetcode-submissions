class Solution {
    public int numDistinct(String s, String t) {
        char[] src = s.toCharArray();
        char[] target = t.toCharArray();

        int m = src.length;
        int n = target.length;

        int[] dp = new int[n + 1];
        int[] curr = new int[n + 1];

        dp[n] = 1;
        
        for (int i = m - 1; i >= 0; i--) {
            curr[n] = 1;
            for (int j = n - 1; j >= 0; j--) {
                int ans = 0;
                if (src[i] == target[j]) {
                    ans += dp[j + 1];
                }

                ans += dp[j];

                curr[j] = ans;
            }

            int[] temp = dp;
            dp = curr;
            curr = temp;
        }
        
        return dp[0];
    }
}
