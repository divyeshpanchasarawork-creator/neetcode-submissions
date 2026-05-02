class NumArray {
    private final int[] prefix;
    public NumArray(int[] nums) {
        prefix = new int[nums.length];
        int curr = 0;
        for (int i = 0; i < prefix.length; i++) {
            curr += nums[i];
            prefix[i] = curr;
        }
    }
    
    public int sumRange(int left, int right) {
        if (left == 0) return prefix[right];
        return prefix[right] - prefix[--left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */