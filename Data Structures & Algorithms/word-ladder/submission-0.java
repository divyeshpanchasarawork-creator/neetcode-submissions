class Solution {
    private class Trie {
        private class TrieNode {
            private final TrieNode[] children = new TrieNode[26];
            String word;
        }

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        private void add(String word) {
            TrieNode curr = root;

            for (char ch : word.toCharArray()) {
                if (curr.children[ch - 'a'] == null)
                    curr.children[ch - 'a'] = new TrieNode();
                curr = curr.children[ch - 'a'];
            }

            curr.word = word;
        }

        public List<String> search(char[] word) {
            List<String> result = new ArrayList<>();
            if (word.length == 0)
                return result;

            helper(0, word, root, result);

            return result;
        }

        private boolean helper(int i, char[] arr, TrieNode curr, List<String> result) {
            if (i >= arr.length) {
                if (curr.word != null)
                    result.add(curr.word);
                return false;
            }

            if (arr[i] == '*') {
                for (int j = 0; j < 26; j++) {
                    if (curr.children[j] != null && helper(i + 1, arr, curr.children[j], result))
                        return true;
                }
                return false;
            }

            return curr.children[arr[i] - 'a'] != null && helper(i + 1, arr, curr.children[arr[i] - 'a'], result);
        }

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Trie trie = new Trie();
        trie.add(beginWord);

        for (String w : wordList)
            trie.add(w);

        if (trie.search(endWord.toCharArray()).isEmpty())
            return 0;

        Map<String, Set<String>> graph = buildGraph(trie, beginWord, wordList);

        System.out.println(graph);

        return bfs(beginWord, endWord, graph);
    }

    private int bfs(String source, String end, Map<String, Set<String>> graph) {
        if (source.equals(end))
            return 1;

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer(source);
        visited.add(source);

        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                String word = q.poll();

                if (graph.containsKey(word)) {
                    for (String next : graph.get(word)) {
                        if (next.equals(end)) {
                            return level + 1;
                        }

                        if (!visited.contains(next)) {
                            visited.add(next);
                            q.offer(next);
                        }
                    }
                }
            }
            level++;
        }

        return 0;
    }

    private Map<String, Set<String>> buildGraph(Trie trie, String beginWord, List<String> wordList) {
        Map<String, Set<String>> graph = new HashMap<>();

        graph.putIfAbsent(beginWord, new HashSet<>());
        findNeighbours(beginWord, beginWord.toCharArray(), trie, graph);

        for (String w : wordList) {
            graph.putIfAbsent(w, new HashSet<>());
            findNeighbours(w, w.toCharArray(), trie, graph);
        }

        return graph;
    }

    private void findNeighbours(String w, char[] arr, Trie trie, Map<String, Set<String>> graph) {
        Set<String> neighborsSet = graph.get(w);

        for (int i = 0; i < arr.length; i++) {
            char temp = arr[i];
            arr[i] = '*';

            List<String> matches = trie.search(arr);

            for (String match : matches) {
                if (!match.equals(w)) {
                    neighborsSet.add(match);
                }
            }

            arr[i] = temp;
        }
    }
}