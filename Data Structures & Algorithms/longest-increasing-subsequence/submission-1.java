class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int skip = dp[i + 1][j];
                int pick = 0;
                if (j == 0 || nums[i] > nums[j - 1]) {
                    pick = 1 + dp[i + 1][i + 1];
                }

                dp[i][j]  = Math.max(skip, pick);
            }
        }

        return dp[0][0];
    }
}