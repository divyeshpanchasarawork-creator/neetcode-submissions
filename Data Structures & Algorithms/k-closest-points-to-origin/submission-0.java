class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int len = points.length;
        mergeSort(points, new double[len], 0, len - 1);
        return Arrays.copyOfRange(points, 0, k);
    }

    private void mergeSort(int[][] p, double[] rad, int l, int r) {
        if (l >= r) {
            rad[l] = Math.sqrt(p[l][0] * p[l][0] + p[l][1] * p[l][1]);
            return;
        }

        int mid = l + (r - l) / 2;

        mergeSort(p, rad, l, mid);
        mergeSort(p, rad, mid + 1, r);

        merge(p, rad, l, r, mid);
    }

    private void merge(int[][] p, double[] rad, int l, int r, int mid) {
        double[] resRad = new double[r - l + 1];
        int[][] resPoints = new int[r - l + 1][2];

        int i = l;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= r) {
            if (rad[i] < rad[j]) {
                resRad[k] = rad[i];
                resPoints[k++] = p[i++];
            } else {
                resRad[k] = rad[j];
                resPoints[k++] = p[j++];
            }
        }

        while (i <= mid) {
            resRad[k] = rad[i];
            resPoints[k++] = p[i++];
        }

        while (j <= r) {
            resRad[k] = rad[j];
            resPoints[k++] = p[j++];
        }

        for (int n = l; n <= r; n++) {
            p[n] = resPoints[n - l];
            rad[n] = resRad[n - l];
        }
    }

}