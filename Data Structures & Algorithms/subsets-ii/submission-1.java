class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> subsets = new ArrayList<>();

        helper(0, nums, new ArrayList<>(), subsets);

        return subsets;
    }

    private void helper(int i, int[] nums, List<Integer> path, List<List<Integer>> subsets) {
        if (i >= nums.length) {
            subsets.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[i]);

        helper(i + 1, nums, path, subsets);

        path.removeLast();

        while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        helper(i + 1, nums, path, subsets);
    }
}
