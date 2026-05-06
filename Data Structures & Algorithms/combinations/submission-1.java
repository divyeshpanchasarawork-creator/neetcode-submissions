class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        helper(n, k, new ArrayList<>(), answer);
        return answer;
    }

    private void helper(int n, int k, List<Integer> path, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(path));
            return; 
        }

        if (n == 0) return;

        helper(n - 1, k, path, result);

        path.add(n);

        helper(n - 1, k - 1, path, result);

        path.removeLast();
    }
}