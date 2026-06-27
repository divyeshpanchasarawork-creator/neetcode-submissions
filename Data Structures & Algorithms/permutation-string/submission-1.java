class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] tFreq = new int[26];

        for (char ch: s1.toCharArray()) tFreq[ch - 'a']++;

        int k = s1.length();
        int[] sFreq = new int[26];
        char[] arr = s2.toCharArray();

        for (int i = 0; i < k && i < arr.length; i++) {
            sFreq[arr[i] - 'a']++;
        }

        if (isPermutation(sFreq, tFreq)) return true;

        for (int i = k; i < arr.length; i++) {
            sFreq[arr[i] - 'a']++;
            sFreq[arr[i - k] - 'a']--;

            if (isPermutation(sFreq, tFreq)) return true;
        }

        return false;
    }

    private boolean isPermutation(int[] s, int[] t) {
        for (int i = 0; i < t.length; i++) if (s[i] != t[i]) return false;
        return true;
    }
}
