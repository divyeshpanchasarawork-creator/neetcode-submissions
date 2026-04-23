class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        int actualXor = 0;

        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            actualXor ^= (i + 1);
        }

        return xor ^ actualXor;
    }
}
