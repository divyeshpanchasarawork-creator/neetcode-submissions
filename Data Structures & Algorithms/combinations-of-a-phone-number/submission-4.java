class Solution {
    private static final String[] map = {
    "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
};

    public List<String> letterCombinations(String digits) {
        List<String> combs = new ArrayList<>();

        if (digits.length() == 0) return combs; 

        helper(0, digits.toCharArray(), new StringBuilder(), combs);

        return combs;
    }

    private void helper(int i, char[] arr, StringBuilder path, List<String> combs) {
        if (i >= arr.length) {
            combs.add(path.toString());
            return;
        }

        for (char ch : Solution.map[arr[i] - '0'].toCharArray()) {
            path.append(ch);
            helper(i + 1, arr, path, combs);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
