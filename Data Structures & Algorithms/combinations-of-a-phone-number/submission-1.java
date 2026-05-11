class Solution {
    private static String[] map = new String[10];

    static {
        map[2] = "abc";
        map[3] = "def";
        map[4] = "ghi";
        map[5] = "jkl";
        map[6] = "mno";
        map[7] = "pqrs";
        map[8] = "tuv";
        map[9] = "wxyz";
    }

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
