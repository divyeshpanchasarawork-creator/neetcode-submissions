class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        int t = -1;
        
        while (right < nums.length) {
            if (nums[right] != 0) {
                t = nums[left];
                nums[left++] = nums[right];
                nums[right] = t;
            }
            right++;
        }
    }
}