class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int i = 0;
        int j = 0;
        int min = Math.min(m, n);
        char[] res = new char[m + n];

        boolean toggle = true;
        while (i < min) {
            if(toggle) res[j] = word1.charAt(i);
            else {
                res[j] = word2.charAt(i);
                i++;
            }
            toggle = !toggle;
            j++;
        }

        while (i < m) {
            res[j++] = word1.charAt(i++);
        }

        while (i < n) {
            res[j++] = word2.charAt(i++);
        }

        return new String(res);
    }
}