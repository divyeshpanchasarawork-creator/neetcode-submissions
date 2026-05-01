class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();

        char[] chArr = s.toCharArray();

        int maxLen = 0;
        int start = 0;

        for (int i = 0; i < chArr.length; i++) {
            if (map.containsKey(chArr[i])) {
                int idx = map.get(chArr[i]);
                for (int k = start; k <= idx; k++) map.remove(chArr[k]);
                start = idx + 1;
            }
            map.put(chArr[i], i);
            maxLen = Math.max(maxLen, map.size());
        }

        return maxLen;
    }
}
