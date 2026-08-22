class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<double[]>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int s = edges[i][0];
            int d = edges[i][1];

            double prob = succProb[i];

            adjList[s].add(new double[]{d, prob});
            adjList[d].add(new double[]{s, prob});
        }

        Queue<double[]> pq = new PriorityQueue<>(
            (a, b) -> {
                return Double.compare(b[1], a[1]);
            }
        );

        pq.offer(new double[]{start_node, 1.0});
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;

        while (!pq.isEmpty()) {
            int s = pq.size();

            for (int i = 0; i < s; i++) {
                double[] arr = pq.poll();

                int currNode = (int)(arr[0]);
                double prob = arr[1];

                if (currNode == end_node) {
                    return prob;
                }

                if (prob < maxProb[currNode]) {
                    continue;
                }

                for (double[] neigh : adjList[currNode]) {
                    int nextNode = (int) neigh[0];
                    double nextProb = neigh[1];

                    double newProb = prob * nextProb;

                    if (newProb > maxProb[nextNode]) {
                        maxProb[nextNode] = newProb;
                        pq.offer(new double[]{nextNode, newProb});
                    }
                }
            }
        }

        return 0.0;
    }
}