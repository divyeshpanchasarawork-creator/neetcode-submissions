class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;

        int currSum = 0;

        int minLen = Integer.MAX_VALUE;

        while (r < nums.length) {
            currSum += nums[r];
            while (currSum >= target) {
                minLen = Math.min(r - l + 1, minLen);
                currSum -= nums[l++];
            }
            r++;
        }

        return minLen != Integer.MAX_VALUE ? minLen : 0;
    }
}