class Solution {
    public boolean isHappy(int n) {
        while (n > 9) {
            int temp  = 0;
            while (n > 0) {
                int l = n % 10;
                temp += l * l;
                n /= 10;
            }
            n = temp;
        }
        if (n == 7) return true;
        return n == 1;
    }
}