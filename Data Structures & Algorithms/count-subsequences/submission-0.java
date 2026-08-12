class Solution {
    public int numDistinct(String s, String t) {
        char[] src = s.toCharArray();
        char[] target = t.toCharArray();

        int m = src.length;
        int n = target.length;

        int[][] memo = new int[m][n];
        for (int[] r : memo) Arrays.fill(r, -1);

        return solve(0, 0, src, target, memo);
    }

    private int solve(int i, int j, char[] src, char[] target, int[][] memo) {
        if (j >= target.length) return 1;
        if (i >= src.length) return 0;

        if (memo[i][j] != -1) return memo[i][j];

        int ans = 0;

        if (src[i] == target[j]) {
            ans += solve(i + 1, j + 1, src, target, memo);
        }

        ans += solve(i + 1, j, src, target, memo);

        return memo[i][j] = ans;
    }
}
