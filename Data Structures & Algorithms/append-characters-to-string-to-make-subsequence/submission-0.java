class Solution {
    public int appendCharacters(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        int i = 0;
        int j = 0;

        while (i < charS.length && j < charT.length) {
            if (charS[i] == charT[j]) j++;
            i++;
        }

        return charT.length - j;
    }
}