class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int e: nums) {
            if (map.containsKey(e)) map.put(e, map.get(e) +  1);
            else map.put(e, 1);
        }

        for (int k: map.keySet()) if (map.get(k) >= 2) return true;

        return false; 
    }
}