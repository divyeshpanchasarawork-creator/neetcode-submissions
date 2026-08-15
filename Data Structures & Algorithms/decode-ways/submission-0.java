class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);

        return solve(0, s.toCharArray(), memo);
    }

    private int solve(int i, char[] arr, int[] memo) {
        if (i >= arr.length) return 1;

        if (arr[i] == '0') return 0;

        if (memo[i] != -1) return memo[i];

        int count = solve(i + 1, arr, memo);

        if (i + 1 < arr.length) {
            int twoDig = (arr[i]  - '0') * 10 + (arr[i + 1] - '0');
            if (twoDig >= 10 && twoDig <= 26) {
                count += solve(i + 2, arr, memo);
            }
        }

        return memo[i] = count;
    }
}
