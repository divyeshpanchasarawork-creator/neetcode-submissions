class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() < text2.length()) {
            return longestCommonSubsequence(text2, text1);
        }
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();

        int m = arr1.length;
        int n = arr2.length;

        int[][] memo = new int[m + 1][n + 1];
        for (int[] r : memo) Arrays.fill(r, -1);

        return solve(0, 0, arr1, arr2, memo);
    }

    private int solve(int i, int j, char[] arr1, char[] arr2, int[][] memo) {
        if (i >= arr1.length || j >= arr2.length) return 0;

        if (memo[i][j] != -1) return memo[i][j];

        if (arr1[i] == arr2[j]) {
            return memo[i][j] = 1 + solve(i + 1, j + 1, arr1, arr2, memo);
        }

        int adv1 = solve(i + 1, j, arr1, arr2, memo);
        int adv2 = solve(i, j + 1, arr1, arr2, memo);

        return memo[i][j] = Math.max(adv1, adv2);
    }
}
