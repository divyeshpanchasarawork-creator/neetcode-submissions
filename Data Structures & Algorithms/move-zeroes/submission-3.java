class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int t = -1;
        
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                t = nums[left];
                nums[left++] = nums[right];
                nums[right] = t;
            }
        }
    }
}