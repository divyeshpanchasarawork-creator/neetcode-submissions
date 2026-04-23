class Solution {
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        for (char ch: s.toCharArray()) freq[ch - 'a']++;

        StringBuilder sb = new StringBuilder();

        for (char ch: order.toCharArray()) {
            if (freq[ch - 'a'] != 0) {
                append(sb, ch, freq[ch - 'a']);
                freq[ch - 'a'] = 0;
            }
        }

        int i = 0;
        for (int f: freq) {
            if (f != 0) append(sb, (char)('a' + i), f);
            freq[i] = 0;
            i++;
        }

        return sb.toString();
    }

    private void append(StringBuilder sb, char ch, int times) {
        while (times-- > 0) sb.append(ch);
    }
}