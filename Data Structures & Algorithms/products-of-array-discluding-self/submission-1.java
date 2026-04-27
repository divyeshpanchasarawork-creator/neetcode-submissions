class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];

        int prev = 1;
        for (int i = 0; i < nums.length; i++) {
            prefix[i] = prev;
            prev *= nums[i];
        }

        prev = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prefix[i] *= prev;
            prev *= nums[i];
        }

        return prefix;
    }
}  
