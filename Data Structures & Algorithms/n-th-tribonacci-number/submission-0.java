class Solution {
    public int tribonacci(int n) {
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return helper(n, memo);
    }

    private int helper(int n, int[] memo) {
        if (n == 0) return 0;
        if (n <= 2) return 1;

        if (memo[n - 1] != -1) return memo[n - 1];

        memo[n - 1] = helper(n - 1, memo) + helper(n - 2, memo) + helper(n - 3, memo);

        return memo[n - 1];
    }
}