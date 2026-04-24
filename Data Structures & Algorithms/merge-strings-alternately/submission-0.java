class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        boolean turn = true;
        while (i < word1.length() && j < word2.length()) {
            if (turn) sb.append(word1.charAt(i++));
            else sb.append(word2.charAt(j++));
            turn = !turn;
        }

        sb.append(word1.substring(i));
        sb.append(word2.substring(j));

        return sb.toString();
    }
}