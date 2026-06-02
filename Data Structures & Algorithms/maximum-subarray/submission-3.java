class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int e: nums) {
            currSum += e;
            maxSum = Math.max(currSum, maxSum);
            currSum = Math.max(currSum, 0);
        }

        return maxSum;
    }
}
