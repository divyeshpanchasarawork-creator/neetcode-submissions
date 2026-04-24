class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) swap(i++, j--, s);
    }

    private void swap(int i, int j, char[] s) {
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
    }
}