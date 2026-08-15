class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        if (s.charAt(0) == '0')
            return 0;

        int next1 = 1;
        int next2 = 0;

        for (int i = n - 1; i >= 0; i--) {
            int curr = 0;

            if (s.charAt(i) != '0') {
                curr = next1;

                if (i + 1 < n) {
                    int twoDig = (s.charAt(i) - '0') * 10
                               + (s.charAt(i + 1) - '0');

                    if (twoDig <= 26)
                        curr += next2;
                }
            }

            next2 = next1;
            next1 = curr;
        }

        return next1;
    }
}