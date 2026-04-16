class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = 0;
        int maxLen = 0;

        for (int e: nums) {
            if (e == 0) {
                maxLen = Math.max(len, maxLen);
                len = 0;
            } else len++;
        }
        
        return Math.max(len, maxLen);
    }
}