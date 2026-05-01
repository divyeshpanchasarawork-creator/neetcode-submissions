class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {
        int count = 0;

        double avg = 0;

        int i = 0;
        int l = 0;
        for (i = 0; i < k - 1; i++) {
            avg += nums[i];
        }
        
        for (i = k - 1; i < nums.length; i++) {
            avg += nums[i];
            if (avg / k >= threshold) count++;
            avg -= nums[l++];
        }
        return count;
    }
}