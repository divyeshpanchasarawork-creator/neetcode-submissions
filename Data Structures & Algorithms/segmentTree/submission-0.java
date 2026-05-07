class SegmentTree {
    private class TreeNode {
        int sum = 0;
        int l = 0;
        int r = 0;
        TreeNode left;
        TreeNode right;

        public TreeNode(int sum, int l, int r) {
            this.sum = sum;
            this.l = l;
            this.r = r;
        }
    }

    private final TreeNode root;

    public SegmentTree(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] arr, int l, int r) {
        if (l == r) {
            TreeNode node = new TreeNode(arr[l], l, r);
            return node;
        }

        int mid = l + (r - l) / 2;

        TreeNode node = new TreeNode(0, l, r);
        node.left = buildTree(arr, l, mid);
        node.right = buildTree(arr, mid + 1, r);
        node.sum = node.left.sum + node.right.sum;

        return node;
    }

    public void update(int index, int val) {
        update(root, index, val);
    }

    private void update(TreeNode root, int index, int val) {
        if (root.l == root.r) {
            root.sum = val;
            return;
        }

        int mid = root.l + (root.r - root.l) / 2;

        if (index > mid) update(root.right, index, val);
        else update(root.left, index, val);

        root.sum = root.left.sum + root.right.sum;
    }

    public int query(int L, int R) {
        return query(root, L, R);
    }

    private int query(TreeNode root, int l, int r) {
        if (root == null) return 0;

        if (root.l == l && root.r == r) {
            return root.sum;
        }

        int mid = root.l + (root.r - root.l) / 2;

        if (l > mid) return query(root.right, l, r);
        else if (r <= mid) return query(root.left, l, r);

        return query(root.left, l, mid) + query(root.right, mid + 1, r);
    }
}
