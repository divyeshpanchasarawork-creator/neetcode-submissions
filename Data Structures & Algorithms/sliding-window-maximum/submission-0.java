class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        Deque<Integer> q = new ArrayDeque<>();
        int ri = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!q.isEmpty() && q.peekFirst() < i - k + 1) {
                q.pollFirst();
            }

            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) q.pollLast();

            q.offerLast(i);

            if (i >= k - 1) result[ri++] = nums[q.peekFirst()];
        }

        return result;
    }
}