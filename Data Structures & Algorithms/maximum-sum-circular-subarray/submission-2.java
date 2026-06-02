class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxGlobal = nums[0], maxCurrent = 0;
        int minGlobal = nums[0], minCurrent = 0;

        for (int x : nums) {
            totalSum += x;
            maxCurrent = Math.max(x, maxCurrent + x);
            maxGlobal = Math.max(maxGlobal, maxCurrent);

            minCurrent = Math.min(x, minCurrent + x);
            minGlobal = Math.min(minGlobal, minCurrent);
        }

        if (maxGlobal < 0) {
            return maxGlobal;
        }

        return Math.max(maxGlobal, totalSum - minGlobal);
    }
}