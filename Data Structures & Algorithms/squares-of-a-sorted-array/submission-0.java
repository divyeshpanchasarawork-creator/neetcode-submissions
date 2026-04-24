class Solution {
    public int[] sortedSquares(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            nums[l] *= nums[l];
            return;
        }

        int mid = l + (r - l) / 2;

        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);

        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] res = new int[r - l + 1];

        int i = l;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= r) {
            if (nums[i] < nums[j]) res[k++] = nums[i++];
            else res[k++] = nums[j++];
        }

        while (i <= mid) res[k++] = nums[i++];
        while (j <= r) res[k++] = nums[j++];

        for (int n = l; n <= r; n++) nums[n] = res[n - l];
    }
}