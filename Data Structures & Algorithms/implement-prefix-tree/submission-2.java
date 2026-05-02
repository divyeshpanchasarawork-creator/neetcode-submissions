class PrefixTree {

    private class TreeNode {
        private final Map<Character, TreeNode> children;
        private boolean isEnd;
        public TreeNode() {
            children = new HashMap<>();
        }
    }

    private final TreeNode root;

    public PrefixTree() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode curr = root;

        for (char ch: word.toCharArray()) {
            curr = curr.children.computeIfAbsent(ch, k -> new TreeNode());
        }
        curr.isEnd = true;
    }

    private TreeNode traverse(String word) {
        TreeNode curr = root;
        for (char ch : word.toCharArray()) {
            curr = curr.children.get(ch);
            if (curr == null) return null;
        }
        return curr;
    }

    public boolean search(String word) {
        TreeNode node = traverse(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String word) {
        return traverse(word) != null;
    }
}
