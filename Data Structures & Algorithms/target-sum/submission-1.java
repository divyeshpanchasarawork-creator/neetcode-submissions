class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return helper(0, nums, target, memo);
    }

    private int helper(int i, int[] nums, int target, Map<String, Integer> memo) {
        if (i >= nums.length) {
            return target == 0 ? 1 : 0;
        }

        String key = i + "," + target;
        if (memo.containsKey(key)) return memo.get(key);

        int result = helper(i + 1, nums, target - nums[i], memo)
                   + helper(i + 1, nums, target + nums[i], memo);

        memo.put(key, result);
        return result;
    }
}