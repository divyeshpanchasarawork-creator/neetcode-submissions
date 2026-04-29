class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n];
        return helper(n, memo);
    }

    private int helper(int n, int[] memo) {
        if (n <= 1) return 1;

        if (memo[n - 1] != 0) return memo[n - 1];

        memo[n - 1] = helper(n - 1, memo) + helper(n - 2, memo);

        return memo[n - 1]; 
    }
}
