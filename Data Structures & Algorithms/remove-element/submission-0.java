class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;

        while (i < nums.length) {
            if (nums[i] == val) i++;
            else {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
                i++;
            }
        }

        return j;
    }
}