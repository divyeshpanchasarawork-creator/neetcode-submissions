class Solution {
    public void reverseWords(char[] s) {
        reverse(s);

        int i = 0;
        while (i < s.length) {
            while (i < s.length && s[i] == ' ') i++;
            int j = i + 1;
            while (j < s.length && s[j] != ' ') j++;
            reverse(s, i, j - 1);
            i = j + 1;
        }
    }

    private void reverse(char[] s, int i, int j) {
        while (i < j) {
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
            i++;
            j--;
        }
    }

    private void reverse(char[] s) {
        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
            i++;
            j--;
        }
    }
}
