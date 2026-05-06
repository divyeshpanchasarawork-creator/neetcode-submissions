class Solution {
    public List<String> generateParenthesis(int n) {
        return helper(new StringBuilder(), n, 0);
    }

    private List<String> helper(StringBuilder s, int open, int close) {
        if (open == 0 && close  == 0) {
            List<String> list = new ArrayList<>();
            list.add(s.toString());
            return list;
        }

        List<String> ans = new ArrayList<>();

        if (open > 0) {
            s.append("(");
            ans.addAll(helper(s, open - 1, close + 1));
            s.deleteCharAt(s.length() - 1);
        }

        if (close > 0) {
            s.append(")");
            ans.addAll(helper(s, open, close - 1));
            s.deleteCharAt(s.length() - 1);
        }

        return ans;
    }
}
