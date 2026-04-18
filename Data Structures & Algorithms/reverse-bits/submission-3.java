class Solution {
    public int reverseBits(int n) {
        int ans = 0;

        for (int i = 31; i >= 0; i--) {
            ans = (ans << 1) | (n & 1);
            n >>= 1;
        }

        return ans;
    }
}
