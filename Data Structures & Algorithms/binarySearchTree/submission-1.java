class TreeMap {
    private class TreeNode {
        int key;
        int val;

        TreeNode left;
        TreeNode right;

        public TreeNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    private TreeNode root;

    public TreeMap() {
        root = null;
    }

    public void insert(int key, int val) {
        root = insert(root, key, val);
    }

    private TreeNode insert(TreeNode root, int key, int val) {
        if (root == null) return new TreeNode(key, val);

        if (key < root.key) root.left = insert(root.left, key, val);
        else if (key > root.key) root.right = insert(root.right, key, val);
        else root.val = val;

        return root;
    }

    public int get(int key) {
        return get(root, key);
    }

    private int get(TreeNode root, int key) {
        if (root == null) return -1;

        if (key == root.key) return root.val;
        else if (key < root.key) return get(root.left, key);
        return get(root.right, key);
    }

    public int getMin() {
        if (root == null) return -1;
        TreeNode minNode = findMin(root);
        return minNode.val;
    }

    public int getMax() {
        if (root == null) return -1;
        TreeNode maxNode = findMax(root);
        return maxNode.val;
    }

    private TreeNode findMax(TreeNode node) {
        while (node.right != null) node = node.right;
        return node;
    }

    public void remove(int key) {
        root = remove(root, key);
    }

    private TreeNode remove(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.key) {
            root.left = remove(root.left, key);
        } else if (key > root.key) {
            root.right = remove(root.right, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode minNode = findMin(root.right);
            root.key = minNode.key;
            root.val = minNode.val;
            root.right = remove(root.right, minNode.key);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }

    public List<Integer> getInorderKeys() {
        return inOrderTraversal(root);
    }

    private List<Integer> inOrderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        List<Integer> left = inOrderTraversal(root.left);
        left.add(root.key);
        left.addAll(inOrderTraversal(root.right));

        return left;
    }
}
