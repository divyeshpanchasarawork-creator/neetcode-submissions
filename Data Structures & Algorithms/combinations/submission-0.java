class Solution {
    public List<List<Integer>> combine(int n, int k) {
        return helper(n, k, new ArrayList<>());
    }

    private List<List<Integer>> helper(int n, int k, List<Integer> path) {
        if (k == 0) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>(path));
            return list; 
        }

        if (n == 0) return new ArrayList<>();

        List<List<Integer>> skip = helper(n - 1, k, path);

        path.add(n);

        skip.addAll(helper(n - 1, k - 1, path));

        path.removeLast();

        return skip;
    }
}