class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();

        if (nums.length == 0) return permutations;

        List<Integer> path = new ArrayList<>();

        helper(nums, path, permutations);

        return permutations;
    }

    private void helper(int[] nums, List<Integer> path, List<List<Integer>> permutations) {
        if (path.size() == nums.length) {
            permutations.add(new ArrayList<>(path));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            int val = nums[j];
            if (val == Integer.MIN_VALUE) continue;

            path.add(val);
            
            nums[j] = Integer.MIN_VALUE;
            helper(nums, path, permutations);
            nums[j] = val;

            path.removeLast();
        }
    }
}
