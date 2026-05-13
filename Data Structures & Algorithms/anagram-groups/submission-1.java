class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new TreeMap<>();
        List<List<String>> result = new ArrayList<>();

        for (String w: strs) {
            String hash = freqSignature(w);
            if (!map.containsKey(hash)) {
                List<String> list = new ArrayList<>();
                map.put(hash, list);
                result.add(list);
            }
            map.get(hash).add(w);
        }

        return result;
    }

    private String freqSignature(String word) {
        int[] freq = new int[26];

        StringBuilder sb = new StringBuilder();

        for (char ch: word.toCharArray()) freq[ch - 'a']++;

        for (int i = 0; i < 26; i++) if (freq[i] > 0) sb.append((char)('a' + i)).append(freq[i]);

        return sb.toString();
    }
}
