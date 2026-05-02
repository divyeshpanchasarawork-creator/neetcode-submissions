class WordDictionary {
    private class TrieNode {
        private final TrieNode[] children = new TrieNode[26];
        private boolean isEnd;
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new TrieNode();
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        char[] arr = word.toCharArray();

        return helper(0, arr, root);
    }

    private boolean helper(int i, char[] arr, TrieNode curr) {
        if (i >= arr.length)
            return curr.isEnd;

        if (arr[i] == '.') {
            for (int j = 0; j < 26; j++) {
                if (curr.children[j] != null && helper(i + 1, arr, curr.children[j])) {
                    return true;
                }
            }
            return false;
        }

        return curr.children[arr[i] - 'a'] != null && helper(i + 1, arr, curr.children[arr[i] - 'a']);
    }
}
