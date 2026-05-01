class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        int l = 0;
        set.add(nums[l]);

        for (int r = l + 1; r < nums.length; r++) {
            if (set.contains(nums[r])) return true;
            else {
                if (set.size() >= k) set.remove(nums[l++]);
                set.add(nums[r]);
            }
        }

        return false;
    }
}