class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return helper(nums, 0, new ArrayList<>());
    }

    private List<List<Integer>> helper(int[] nums, int i, List<Integer> path) {
        if (i >= nums.length) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>(path));
            return list;
        }
        path.add(nums[i]);
        List<List<Integer>> pick = helper(nums, i + 1, path);
        path.removeLast();

        List<List<Integer>> skip = helper(nums, i + 1, path);

        pick.addAll(skip);

        return pick;
    }
}
