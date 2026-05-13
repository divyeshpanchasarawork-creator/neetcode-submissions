class Solution {
    public int[] plusOne(int[] digits) {
        int c = 1;
        int i = digits.length - 1;

        while (i >= 0) {
            int sum = digits[i] + c;
            digits[i] = sum % 10;
            c = sum/10;
            i--; 
        }
        if (c == 0) return digits;
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        for (int j = 1; j < ans.length; j++) ans[j] = digits[j - 1];
        return ans;
    }
}