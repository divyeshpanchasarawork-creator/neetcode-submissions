class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        
        int prev = 0;
        int i = 0;

        while (i < nums.length) {
            if (nums[prev] != nums[i]) {
                prev++;
                nums[prev] = nums[i];
            }
            i++;
        }

        return prev + 1;
    }
}