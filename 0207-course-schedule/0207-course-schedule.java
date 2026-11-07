class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Step 1: Build the graph
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] edge : prerequisites) {
            int u = edge[1];
            int v = edge[0];

            graph.get(u).add(v);
            indegree[v]++;
        }

        // Step 2: Add all nodes with indegree 0
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Step 3: Apply BFS
        int count = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();
            count++;

            for (int neighbour : graph.get(node)) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        // Step 4: Check for cycle
        return count == numCourses;
    }
}