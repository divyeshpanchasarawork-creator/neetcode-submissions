class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(0, nums, 0);
    }

    private int helper(int i, int[] nums, int xor) {
        if (i >= nums.length) return xor;

        int skip = helper(i + 1, nums, xor);
        int pick = helper(i + 1, nums, xor ^ nums[i]);

        return skip + pick;
    }
}