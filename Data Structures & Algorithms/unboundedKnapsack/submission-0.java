class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int[][] dp = new int[profit.size()][capacity + 1];

        for (int[] r : dp) Arrays.fill(r, -1);

        return solve(0, profit, weight, capacity, dp);
    }

    private int solve(
        int i,
        List<Integer> profit,
        List<Integer> weight,
        int cap,
        int[][] dp
    ) {
        if (cap == 0 || i >= profit.size()) return 0;
        if (dp[i][cap] != -1) return dp[i][cap];

        int next = solve(i + 1, profit, weight, cap, dp);

        int stay = 0;

        if (cap - weight.get(i) >= 0) {
            stay = profit.get(i) + solve(i, profit, weight, cap - weight.get(i), dp);
        }

        return dp[i][cap] = Math.max(next, stay);
    }
}
