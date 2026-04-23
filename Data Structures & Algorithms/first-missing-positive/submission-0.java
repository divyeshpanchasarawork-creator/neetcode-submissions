class Solution {
    public int firstMissingPositive(int[] nums) {
        cycleSort(nums);
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) break;
        }

        return i + 1;
    }

    private void cycleSort(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            int currIdx = nums[i] - 1;

            if (currIdx >= nums.length || currIdx < 0 || nums[currIdx] == currIdx + 1) i++;
            else swap(nums, i, currIdx);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}