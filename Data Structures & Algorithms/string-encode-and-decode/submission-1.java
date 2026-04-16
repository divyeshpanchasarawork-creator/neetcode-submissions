class Solution {
    private int code = 1626;
    
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s: strs) {
            for (char ch: s.toCharArray()) {
                sb.append((char)(ch ^ code));
            }
            sb.append("#");
        }
        System.out.println(sb);
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for (char ch: str.toCharArray()) {
            if (ch  == '#') {
                ans.add(temp.toString());
                temp.setLength(0);
            } else temp.append((char)(ch ^ code));
        }
        
        return ans;
    }
}
