class Graph {
    private final HashMap<Integer, Set<Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>(); 
    }

    private boolean search(int val) {
        return adjList.containsKey(val);
    }

    public void addEdge(int src, int dst) {
        if (!search(src)) adjList.put(src, new HashSet<>());
        if (!search(dst)) adjList.put(dst, new HashSet<>());
        adjList.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if (!search(src)) return false;
        if (!search(dst)) return false;
        adjList.get(src).remove(dst);
        return true;
    }

    public boolean hasPath(int src, int dst) {
        if (!search(src) || !search(dst)) return false;

        return bfs(src, dst, new HashSet<>());
    }

    private boolean dfs(int src, int dst, Set<Integer> visited) {
        if (visited.contains(src)) return false;

        if (src == dst) return true;
        visited.add(src);
        boolean canReachDst = false;
        for (int neighbour: adjList.get(src)) {
            canReachDst = dfs(neighbour, dst, visited);
            if (canReachDst) break;
        }
        visited.remove(src);

        return canReachDst;
    }

    private boolean bfs(int src, int dst, Set<Integer> visited) {
        Queue<Integer> queue = new LinkedList<>();

        if (src == dst) return true;

        queue.offer(src);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.remove();
                if (node == dst) return true;
                visited.add(node);
                for (int n: adjList.get(node)) {
                    if (!visited.contains(n)) {
                        queue.offer(n);
                    }
                }
            }
        }
        return false;
    }
}
