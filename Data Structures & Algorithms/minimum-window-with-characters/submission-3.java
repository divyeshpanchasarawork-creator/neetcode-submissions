class Solution {
    public String minWindow(String s, String t) {
        int[] tFreq = new int[58];

        for (int ch : t.toCharArray()) {
            tFreq[ch - 65]++;
        }

        int l = 0;
        int r = 0;

        int minL = 0;
        int minR = Integer.MAX_VALUE;

        char[] arr = s.toCharArray();
        int[] sFreq = new int[58];

        int need = t.length();

        while (r < arr.length) {

            int right = arr[r] - 65;
            sFreq[right]++;

            if (sFreq[right] <= tFreq[right]) {
                need--;
            }

            while (need == 0) {

                if (minR - minL > r - l) {
                    minR = r;
                    minL = l;
                }

                int left = arr[l] - 65;
                sFreq[left]--;

                if (sFreq[left] < tFreq[left]) {
                    need++;
                }

                l++;
            }

            r++;
        }

        if (minR == Integer.MAX_VALUE) {
            return "";
        }

        return new String(arr, minL, minR - minL + 1);
    }
}