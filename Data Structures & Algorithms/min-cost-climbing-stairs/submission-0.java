class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length];
        Arrays.fill(memo, -1);
        helper(0, cost, memo);
        return Math.min(memo[0], memo[1]);
    }

    private int helper(int i, int[] cost, int[] memo) {
        if (i >= cost.length) return 0;

        if (memo[i] != -1) return memo[i];

        int one = helper(i + 1, cost, memo);
        int two = helper(i + 2, cost, memo);

        memo[i] = cost[i] + Math.min(one, two);

        return memo[i];
    }
}
