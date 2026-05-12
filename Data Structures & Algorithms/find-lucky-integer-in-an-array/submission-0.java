class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[500];

        for (int e: arr) freq[e - 1]++;

        for (int i = freq.length - 1; i >= 0; i--) {
            if (freq[i] == i + 1) return i + 1;
        }

        return -1;
    }
}