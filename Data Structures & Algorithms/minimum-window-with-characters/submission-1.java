class Solution {
    public String minWindow(String s, String t) {
        int[] tFreq = new int[58];

        for (int ch : t.toCharArray()) tFreq[ch - 65]++;

        int l = 0;
        int r = 0;
        int minL = 0;
        int minR = Integer.MAX_VALUE;

        char[] arr = s.toCharArray();
        int[] sFreq = new int[58];

        while (r < arr.length) {
            sFreq[arr[r] - 65]++;

            while (isMatch(sFreq, tFreq)) {
                if (minR - minL > r - l) {
                    minR = r;
                    minL = l;
                }

                sFreq[arr[l++] - 65]--;
            }

            r++;
        }
        if (minR == Integer.MAX_VALUE) return "";

        return new String(arr, minL, minR - minL + 1);
    }

    private boolean isMatch(int[] sFreq, int[] tFreq) {
        for (int i = 0; i < tFreq.length; i++) {
            if (tFreq[i] != 0 && sFreq[i] < tFreq[i]) return false;
        }

        return true;
    }
}
