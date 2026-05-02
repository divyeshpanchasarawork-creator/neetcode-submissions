class PrefixTree {

    private class TreeNode {
        char ch;
        private Map<Character, TreeNode> children;

        public TreeNode(char ch) {
            this.ch = ch;
            children = new HashMap<>();
        }
    }

    private final TreeNode root;

    public PrefixTree() {
        root = new TreeNode('/');
    }

    public void insert(String word) {
        TreeNode curr = root;

        for (char ch: word.toCharArray()) {
            if (curr.children.containsKey(ch)) curr = curr.children.get(ch);
            else {
                TreeNode node = new TreeNode(ch);
                curr.children.put(ch, node);
                curr = curr.children.get(ch);
            }
        }
        curr.children.put(null, null);
    }

    public boolean search(String word) {
        TreeNode curr = root;

        for (char ch: word.toCharArray()) {
            if (curr.children.containsKey(ch)) curr = curr.children.get(ch);
            else return false;
        }

        return curr.children.containsKey(null);
    }

    public boolean startsWith(String word) {
        TreeNode curr = root;

        for (char ch: word.toCharArray()) {
            if (curr.children.containsKey(ch)) curr = curr.children.get(ch);
            else return false;
        }

        return true;
    }
}
