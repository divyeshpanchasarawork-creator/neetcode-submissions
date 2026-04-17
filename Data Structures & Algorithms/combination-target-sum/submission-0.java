class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        solve(nums, 0, target, new ArrayList<>(), ans);

        return ans;
    }

    private void solve(
        int[] nums, int i, int target, List<Integer> path, List<List<Integer>> finalAns) {
            if (target == 0) {
                finalAns.add(new ArrayList<>(path));
                return;
            }

            if (i >= nums.length || target < 0) return;


            path.add(nums[i]);
            target -= nums[i];
            solve(nums, i, target, path, finalAns);
            target += nums[i];
            path.removeLast();

            solve(nums, i + 1, target, path, finalAns);
        }
}
