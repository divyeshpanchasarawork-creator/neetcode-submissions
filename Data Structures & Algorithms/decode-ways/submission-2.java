class Solution {
    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        if (arr[0] == '0')
            return 0;

        int next1 = 1;
        int next2 = 0;

        int curr = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] != '0') {
                curr += next1;

                if (i + 1 < n) {
                    int twoDig = (arr[i] - '0') * 10 + (arr[i + 1] - '0');
                    if (twoDig >= 10 && twoDig <= 26) {
                        curr += next2;
                    }
                }
            }

            next2 = next1;
            next1 = curr;
            curr = 0;
        }

        return next1;
    }
}
