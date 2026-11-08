import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        // Edge case
        if (n == 1) {
            return Arrays.asList(0);
        }

        // 1. Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 2. Calculate degree of every node
        int[] degree = new int[n];

        for (int i = 0; i < n; i++) {
            degree[i] = graph.get(i).size();
        }

        // 3. Add initial leaf nodes to queue
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        // 4. Remove leaf layers
        int remaining = n;

        while (remaining > 2) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int leaf = queue.poll();

                for (int neighbor : graph.get(leaf)) {

                    degree[neighbor]--;

                    if (degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }

            remaining -= size;
        }

        // 5. Return the center node(s)
        return new ArrayList<>(queue);
    }
}