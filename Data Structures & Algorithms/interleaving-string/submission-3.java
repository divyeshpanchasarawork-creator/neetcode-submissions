class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        char[] arr3 = s3.toCharArray();

        byte[][] memo = new byte[arr1.length + 1][arr2.length + 1];

        return dfs(0, 0, arr1, arr2, arr3, memo);
    }

    private boolean dfs(int i, int j, char[] a1, char[] a2, char[] a3, byte[][] memo) {
        if (i == a1.length && j == a2.length) return true;
        if (memo[i][j] != 0) return memo[i][j] == 2;

        int k = i + j;
        if (i < a1.length && a1[i] == a3[k] && dfs(i + 1, j, a1, a2, a3, memo)) {
            memo[i][j] = 2;
            return true;
        }

        if (j < a2.length && a2[j] == a3[k] && dfs(i, j + 1, a1, a2, a3, memo)) {
            memo[i][j] = 2;
            return true;
        }

        memo[i][j] = 1;
        return false;
    }
}