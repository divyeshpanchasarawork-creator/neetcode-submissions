class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() < text2.length()) {
            return longestCommonSubsequence(text2, text1);
        }
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();

        int m = arr1.length;
        int n = arr2.length;

        int[] dp = new int[n + 1];

        for (int i = m - 1; i >= 0; i--) {
            int diag = 0;
            int right = 0;

            for (int j = n - 1; j >= 0; j--) {
                int bottom = dp[j];

                if (arr1[i] == arr2[j]) {
                    dp[j] = 1 + diag;
                } else {
                    dp[j] = Math.max(bottom, right);
                }
                diag = bottom;
                right = dp[j];
            }
        }

        return dp[0];
    }
}
