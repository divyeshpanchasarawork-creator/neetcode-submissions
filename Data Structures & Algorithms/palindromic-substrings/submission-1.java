class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        char[] arr = s.toCharArray();
        int n = arr.length;

        Boolean[][] memo = new Boolean[n][n];

        for (int l = 0; l < n; l++) {
            for (int r = n - 1; r >= l; r--) {
                if (isPalindrome(arr, l, r, memo)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isPalindrome(char[] arr, int l, int r, Boolean[][] memo) {
        if (l >= r) return memo[l][r] = true;

        if (memo[l][r] != null) return memo[l][r];

        return memo[l][r] = (arr[l] == arr[r]) && isPalindrome(arr, l + 1, r - 1, memo);
    }
}
