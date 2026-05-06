class Solution {
    public List<String> generateParenthesis(int n) {
        return helper("", n, 0);
    }

    private List<String> helper(String s, int open, int close) {
        if (open == 0 && close  == 0) {
            List<String> list = new ArrayList<>();
            list.add(s);
            return list;
        }

        List<String> ans = new ArrayList<>();

        if (open > 0) {
            ans.addAll(helper(s + "(", open - 1, close + 1));
        }

        if (close > 0) {
            ans.addAll(helper(s + ")", open, close - 1));
        }

        return ans;
    }
}
