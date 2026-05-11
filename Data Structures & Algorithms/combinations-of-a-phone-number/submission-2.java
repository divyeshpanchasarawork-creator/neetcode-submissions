class Solution {
    private static final String[] map = {
    "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
};

    public List<String> letterCombinations(String digits) {
        List<String> combs = new ArrayList<>();

        if (digits.length() == 0) return combs; 

        helper(0, digits.toCharArray(), new StringBuilder(), Solution.map, combs);

        return combs;
    }

    private void helper(int i, char[] arr, StringBuilder path, String[] map, List<String> combs) {
        if (i >= arr.length) {
            combs.add(path.toString());
            return;
        }

        for (char ch : map[arr[i] - '0'].toCharArray()) {
            path.append(ch);
            helper(i + 1, arr, path, map, combs);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
