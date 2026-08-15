class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int temp = dp[i + 1];
            for (int j = i; j >= 0; j--) {
                int pick = 0;
                
                if (j == 0 || nums[i] > nums[j - 1]) {
                    pick = 1 + temp;
                }

                dp[j] = Math.max(dp[j], pick);
            }
        }

        return dp[0];
    }
}