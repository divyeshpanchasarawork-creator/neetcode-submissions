// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        mergeSortPairs(0, pairs.size() - 1, pairs);
        return pairs;
    }

    private void mergeSortPairs(int l, int r, List<Pair> pairs) {
        if (l >= r) return;

        int mid = l + (r - l) / 2;

        mergeSortPairs(l, mid, pairs);
        mergeSortPairs(mid + 1, r, pairs);

        merge(pairs, l, mid, r);
    }


    private void merge(List<Pair> list, int l, int mid, int r) {
        List<Pair> ans = new ArrayList<>();

        int i = l;
        int j = mid + 1;

        while (i <= mid && j <= r) {
            Pair p1 = list.get(i);
            Pair p2 = list.get(j);

            if (p1.key <= p2.key) {
                ans.add(p1);
                i++;
            } else {
                ans.add(p2);
                j++;
            }
        }

        while (i <= mid) ans.add(list.get(i++));
        while (j <= r) ans.add(list.get(j++));

        for (int k = l; k <= r; k++) {
            list.set(k, ans.get(k - l));
        }
    }
}
