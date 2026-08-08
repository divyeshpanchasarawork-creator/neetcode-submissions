class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;

        for (int e: nums) total += e;

        int target = total / 2;

        if (total % 2 != 0) return false;

        Boolean[][] dp = new Boolean[nums.length][target + 1];

        return solve(0, nums, target, dp);
    }

    private boolean solve(int i, int[] nums, int target, Boolean[][] dp) {
        if (target == 0) return true;
        if (i >= nums.length) return false;

        if (dp[i][target] != null) return dp[i][target];

        boolean ans = solve(i + 1, nums, target, dp);

        if (target - nums[i] >= 0) {
            ans = ans || solve(i + 1, nums, target - nums[i], dp);
        }

        return dp[i][target] = ans;
    }
}
