class Solution {
    public int reverse(int x) {
        int temp = Math.abs(x);
        long rev = 0;

        while (temp > 0) {
            rev *= 10;
            rev += temp % 10;
            temp /= 10;
        }
        if (rev > Integer.MAX_VALUE) return 0;

        return x < 0 ? (int)-rev : (int)rev;
    }
}
