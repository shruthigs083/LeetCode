class Solution {
    public List<Boolean> checkIfPrerequisite(
        int numCourses, int[][] prerequisites, int[][] queries) {

        // Step 1: Create the reachability matrix
        boolean[][] reachable = new boolean[numCourses][numCourses];

        // Step 2: Mark direct prerequisites
        for (int[] edge : prerequisites) {
            int a = edge[0];
            int b = edge[1];

            reachable[a][b] = true;
        }

        // Step 3: Find indirect prerequisites using Floyd-Warshall
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {

                    if (reachable[i][k] && reachable[k][j]) {
                        reachable[i][j] = true;
                    }
                }
            }
        }

        // Step 4: Answer the queries
        List<Boolean> answer = new ArrayList<>();

        for (int[] query : queries) {
            int u = query[0];
            int v = query[1];

            answer.add(reachable[u][v]);
        }

        return answer;
    }
}