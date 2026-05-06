class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int t = -1;

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i]&1) == 0) {
                t = nums[left];
                nums[left++] = nums[i];
                nums[i] = t;
            }
        }
        return nums;
    }
}