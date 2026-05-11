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

        int j = i + 1;
        while (j < nums.length && nums[j] == nums[i]) j++;
        helper(j, nums, path, subsets);

        path.add(nums[i]);

        helper(i + 1, nums, path, subsets);

        path.removeLast();
    }
}
