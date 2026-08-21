class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;

        int maxFreq = 0;
        int maxLen = 0;

        int[] freq = new int[26];
        char[] arr = s.toCharArray();

        while (r < arr.length) {
            freq[arr[r] - 'A']++;

            maxFreq = Math.max(maxFreq, freq[arr[r] - 'A']);

            while ((r - l + 1) - maxFreq > k) {
                freq[arr[l++] - 'A']--;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }
}
