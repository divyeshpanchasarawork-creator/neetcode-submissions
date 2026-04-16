class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;

        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        int i = 0;
        int j = 0;

        while (i < charS.length && j < charT.length) {
            if (charS[i] == charT[j]) i++;
            j++;
        }

        return i == charS.length;
    }
}