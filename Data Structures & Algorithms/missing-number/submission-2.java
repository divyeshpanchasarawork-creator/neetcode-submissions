class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        for (int e: nums) xor ^= e;
        return xor ^ findXORSum(nums.length);
    }

    private int findXORSum(int n) {
        switch (n % 4) {
            case 0:
                return n;
            case 1:
                return 1;
            case 2:
                return n + 1;
            case 3:
                return 0;
        }
        return 0;
    }
}
