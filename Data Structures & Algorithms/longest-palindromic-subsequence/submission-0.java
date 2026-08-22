class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length - 1;
        int[][] memo = new int[n + 1][n + 1];
        for (int[] r : memo) Arrays.fill(r, -1);

        return solve(0, arr.length - 1, arr, memo);
    }

    private int solve(int l, int r, char[] arr, int[][] memo) {
        if (l > r) return 0;
        if (l == r) return 1;

        if (memo[l][r] != -1) return memo[l][r];

        if (arr[l] == arr[r]) return memo[l][r] = 2 + solve(l + 1, r - 1, arr, memo);

        int skip1 = solve(l + 1, r, arr, memo);
        int skip2 = solve(l,r - 1, arr, memo);

        return memo[l][r] = Math.max(skip1, skip2);
    }
}