class Solution {
    public int pivotIndex(int[] nums) {
        int arrSum = 0;
        for (int e: nums) arrSum += e;

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * leftSum == arrSum - nums[i]) return i;
            leftSum += nums[i];
        }

        return -1;
    }
}