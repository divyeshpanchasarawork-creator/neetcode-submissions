class Solution {
    public boolean validPalindrome(String s) {
        return helper(s.toCharArray(), 0, s.length() - 1, new boolean[]{true});
    }

    private boolean helper(char[] arr, int l, int r, boolean[] delete) {
        if (l >= r) return true;

        if (arr[l] != arr[r]) {
            if (delete[0]) {
                delete[0] = false;
                return helper(arr, l + 1, r, delete) || helper(arr, l, r - 1, delete);
            }
            return false;
        }

        return helper(arr, l + 1, r - 1, delete);
    }
}