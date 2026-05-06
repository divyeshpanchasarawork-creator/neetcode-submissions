class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return helper(0, candidates, target, new ArrayList<>());
    }

    private List<List<Integer>> helper(int i, int[] arr, int target, List<Integer> path) {
        if (target == 0) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>(path));
            return list;
        }

        if (i >= arr.length || target < 0) return new ArrayList<>();

        int j = i + 1;
        while (j < arr.length && arr[i] == arr[j]) j++;
        List<List<Integer>> skip = helper(j, arr, target, path);

        path.add(arr[i]);

        List<List<Integer>> pick = helper(i + 1, arr, target - arr[i], path);

        path.removeLast();

        skip.addAll(pick);

        return skip;
    }
}
