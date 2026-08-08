class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int[][] dp = new int[profit.size()][capacity + 1];

        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        return solve(0, profit, weight, capacity, dp);
    }

    private int solve(int i,
        List<Integer> profit,
        List<Integer> weight,
        int capacity,
        int[][] dp
    ) {
        if (capacity == 0) return 0;
        if (i >= profit.size()) return 0;

        if (dp[i][capacity] != -1) return dp[i][capacity];

        int skip = solve(i + 1, profit, weight, capacity, dp);
        int pick = 0;

        if (capacity - weight.get(i) >= 0) {
            pick += profit.get(i) + solve(i + 1,
                    profit,
                    weight,
                    capacity - weight.get(i),
                    dp);
        }

        return dp[i][capacity] = Math.max(pick, skip);
    }
}
