class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;    
    }

    private void mergeSort(int[] nums, int i, int j) {
        if (i >= j) return;

        int mid = i + (j - i) / 2;

        mergeSort(nums, i, mid);
        mergeSort(nums, mid + 1, j);

        merge(nums, i, mid, j);
    }

    private void merge(int[] nums, int i, int mid, int j) {
        int[] res = new int[j - i + 1];

        int l = i;
        int m = mid + 1;
        int n = j;

        int k = 0;

        while (l <= mid && m <= n) {
            if (nums[l] <= nums[m]) {
                res[k] = nums[l++];
            } else res[k] = nums[m++];
            k++;
        }

        while (l <= mid) res[k++] = nums[l++];

        while (m <= n) res[k++] = nums[m++];

        for (int z = 0; z < k; z++) {
            nums[i + z] = res[z];
        }
    }
}