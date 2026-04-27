class Solution {
    public int findDuplicate(int[] nums) {
        cycleSort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return nums[i];
        }

        return -1;
    }

    private void cycleSort(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            if (nums[i] < 1 || nums[i] >= nums.length || nums[i] == nums[nums[i] - 1]) i++;
            else swap(nums, i, nums[i] - 1);
        }
    }

    private void swap(int[] n, int i, int j) {
        int t = n[i];
        n[i] = n[j];
        n[j] = t;
    }
}
