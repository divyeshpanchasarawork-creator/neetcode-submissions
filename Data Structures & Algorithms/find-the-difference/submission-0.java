class Solution {
    public char findTheDifference(String s, String t) {
        int sXor = 0;
        int tXor = 0;
        int i = 0;
        for (i = 0; i < s.length(); i++) {
            sXor ^= s.charAt(i);
            tXor ^= t.charAt(i);
        }
        tXor ^= t.charAt(i);

        return (char)(sXor ^ tXor);
    }
}