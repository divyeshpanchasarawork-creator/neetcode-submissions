class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];

        for (int[] r: dp) Arrays.fill(r, -1);

        return solve(0, coins, amount, dp);
    }

    private int solve(int i, int[] coins, int amount, int[][] dp) {
        if (amount == 0) {
            return 1;
        }

        if (i >= coins.length) return 0;

        if (dp[i][amount] != -1) return dp[i][amount];

        int ans = solve(i + 1, coins, amount, dp);

        if (amount - coins[i] >= 0) {
            ans += solve(i, coins, amount - coins[i], dp); 
        }

        dp[i][amount] = ans;

        return ans;
    }
}
