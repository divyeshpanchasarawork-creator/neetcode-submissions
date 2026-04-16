class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;

        int len = 0;

        char[] charS = s.toCharArray();

        while (i >= 0 && charS[i] == ' ') i--;
        while (i >= 0 && charS[i--] != ' ') len++;

        return len;
    }
}