class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new TreeMap<>();

        for (String w: strs) {
            String hash = freqSignature(w);
            if (!map.containsKey(hash)) map.put(hash, new ArrayList<>());
            map.get(hash).add(w);
        }

        List<List<String>> result = new ArrayList<>();

        for (String key: map.keySet()) result.add(map.get(key));

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
