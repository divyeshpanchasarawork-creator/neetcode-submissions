class Solution {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        boolean[][] dp = new boolean[n][n];

        int start = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int l = n - 1; l >= 0; l--) {
            for (int r = l + 1; r < n; r++) {
                dp[l][r] = arr[l] == arr[r] && (r - l == 1 || dp[l + 1][r - 1]);

                if (dp[l][r] && r - l > end - start) {
                    start = l;
                    end = r;
                }
            }
        }

        return s.substring(start, end + 1);
    }
}