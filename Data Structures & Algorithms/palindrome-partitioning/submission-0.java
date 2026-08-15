class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();
        List<String> curr = new ArrayList<>();

        solve(0, s.toCharArray(), curr, answer);

        return answer;
    }

    private void solve(int i, char[] arr, List<String> curr, List<List<String>> ans) {
        if (i >= arr.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j < arr.length; j++) {
            if (isPalindrome(arr, i, j)) {
                curr.add(new String(arr, i, j - i + 1));

                solve(j + 1, arr, curr, ans);

                curr.removeLast();
            }
        }
    }

    private boolean isPalindrome(char[] arr, int i, int j) {
        while (i < j) {
            if (arr[i++] != arr[j--]) return false;
        }

        return true;
    }
}
