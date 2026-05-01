class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return -1;

        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int e: nums) {
            currSum += e;
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0) currSum = 0;
        }

        return maxSum;
    }
}
