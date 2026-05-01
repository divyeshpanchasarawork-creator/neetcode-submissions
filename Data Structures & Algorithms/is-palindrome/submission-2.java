class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            while (i < j && !isAlphaNum(arr[i])) i++;
            while (i < j && !isAlphaNum(arr[j])) j--;

            if (arr[i] != arr[j]) return false;
            i++;
            j--;
        }

        return true;
    }

    private boolean isAlphaNum(char ch) {
        if (ch >= '0' && ch <= '9') return true;
        return ch >= 'a' && ch <= 'z';
    }
}
