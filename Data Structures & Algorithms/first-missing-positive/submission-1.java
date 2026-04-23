class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean[] map = new boolean[nums.length + 1];

        for (int e: nums) {
            if (e > 0 && e <= nums.length) map[e] = true;
        }

        int i = 1;
        for (i = 1; i < map.length; i++) if (!map[i]) return i;

        return nums.length + 1;
    }
}