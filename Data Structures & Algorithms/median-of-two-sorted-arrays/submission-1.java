class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] merged = merge(nums1, nums2, m, n);
        int mid = (m + n) /  2;

        if ((m + n) % 2 != 0) return merged[mid];

        return ((double)merged[mid - 1] + merged[mid]) / 2.0;
    }

    private int[] merge(int[] nums1, int[] nums2, int m, int n) {
        int[] arr = new int[1 + (m + n) / 2];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n && k < arr.length) {
            if (nums1[i] <= nums2[j]) arr[k++] = nums1[i++];
            else arr[k++] = nums2[j++];
        }

        while (i < m && k < arr.length) arr[k++] = nums1[i++];
        while (j < n && k < arr.length) arr[k++] = nums2[j++];

        return arr;
    }
}
