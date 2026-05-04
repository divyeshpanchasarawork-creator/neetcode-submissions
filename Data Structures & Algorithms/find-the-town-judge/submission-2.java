class Solution {
    private class Graph {
        private final Map<Integer, Set<Integer>> adjList;
        
        public Graph() { adjList = new HashMap<>(); }

        public void addNode(int node) {
            if (adjList.containsKey(node)) return;
            adjList.put(node, new HashSet<>());
        }

        public void addEdge(int src, int dst) {
            addNode(src);
            addNode(dst);
            adjList.get(src).add(dst);
        }

        public void buildGraph(int[][] edges) {
            for (int[] e: edges) this.addEdge(e[0], e[1]);
        }

        private int nodeWithZeroNeighbours() {
            for (int node: adjList.keySet()) {
                if (adjList.get(node).size() == 0) return node;
            }
            return -1;
        }

        public int findJudge() {
            int node = this.nodeWithZeroNeighbours();

            if (node == -1) return -1;

            for (int n: adjList.keySet()) {
                Set<Integer> neighbours = adjList.get(n);
                if (n != node && !neighbours.contains(node)) return -1;
            }

            return node;
        }
    }
    public int findJudge(int n, int[][] trust) {
        Graph graph = new Graph();
        graph.buildGraph(trust);
        return graph.findJudge();
    }
}