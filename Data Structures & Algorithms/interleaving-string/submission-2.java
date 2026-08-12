class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        char[] arr3 = s3.toCharArray();

        int m = arr1.length;
        int n = arr2.length;

        BitSet dp = new BitSet(n + 1);

        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m && j == n) {
                    dp.set(j, true);
                } else if (i == m) {
                    dp.set(j, (arr2[j] == arr3[m + j]) && dp.get(j + 1));
                } else if (j == n) {
                    dp.set(j, (arr1[i] == arr3[i + n]) && dp.get(j));
                } else {
                    boolean takeS1 = (arr1[i] == arr3[i + j]) && dp.get(j);
                    boolean takeS2 = (arr2[j] == arr3[i + j]) && dp.get(j + 1);
                    dp.set(j, takeS1 || takeS2);
                }
            }
        }

        return dp.get(0);
    }
}
