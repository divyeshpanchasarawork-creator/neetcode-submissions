class Solution {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();

        int[] ans = {0, 0};

        Boolean[][] memo = new Boolean[arr.length][arr.length];

        for (int l = 0; l < arr.length; l++) {
            for (int r = l; r < arr.length; r++) {
                if (isPalindrome(l, r, arr, memo)) {
                    if (r - l > ans[1] - ans[0]) {
                        ans[0] = l;
                        ans[1] = r;
                    }
                }
            }
        }

        return s.substring(ans[0], ans[1] + 1);
    }

    private boolean isPalindrome(int l, int r, char[] arr, Boolean[][] memo) {
        if (memo[l][r] != null) return memo[l][r];

        if (l >= r) return memo[l][r] = true;

        if (arr[l] != arr[r]) return memo[l][r] = false;

        return memo[l][r] = isPalindrome(l + 1, r - 1, arr, memo);
    }
}