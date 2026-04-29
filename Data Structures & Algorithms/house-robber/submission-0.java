class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return helper(nums, 0, memo);
    }

    private int helper(int[] nums, int i, int[] memo) {
        if (i >= nums.length) return 0;

        if (memo[i] != -1) return memo[i];

        int pick = nums[i] + helper(nums, i + 2, memo);
        int skip = helper(nums, i + 1, memo);
        memo[i] = Math.max(pick, skip);
        
        return memo[i];
    }
}
