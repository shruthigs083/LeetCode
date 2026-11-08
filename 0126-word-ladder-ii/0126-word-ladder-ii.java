class Solution {

    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> findLadders(
        String beginWord, String endWord, List<String> wordList) {

        // Step 1: Convert wordList into HashSet
        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return result;
        }

        // Step 2: Store all parents of each word
        Map<String, List<String>> parents = new HashMap<>();

        // Step 3: Initialize BFS
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        set.remove(beginWord);

        boolean found = false;

        // Step 4: BFS traversal
        while (!queue.isEmpty() && !found) {

            int size = queue.size();

            Set<String> used = new HashSet<>();

            for (int i = 0; i < size; i++) {

                String word = queue.poll();

                StringBuilder sb = new StringBuilder(word);

                // Change each character
                for (int j = 0; j < word.length(); j++) {

                    char originalChar = sb.charAt(j);

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        sb.setCharAt(j, ch);

                        String newWord = sb.toString();

                        if (set.contains(newWord)) {

                            // Store all parents
                            parents.putIfAbsent(
                                newWord, new ArrayList<>());

                            parents.get(newWord).add(word);

                            // Enqueue only once per level
                            if (used.add(newWord)) {

                                if (newWord.equals(endWord)) {
                                    found = true;
                                } else {
                                    queue.offer(newWord);
                                }
                            }
                        }
                    }

                    // Restore original character
                    sb.setCharAt(j, originalChar);
                }
            }

            // Remove discovered words after the entire level
            set.removeAll(used);
        }

        // Step 5: Backtracking
        if (found) {
            path.add(endWord);
            dfs(endWord, beginWord, parents);
        }

        return result;
    }

    // Step 6: Construct all shortest paths
    private void dfs(
        String word,
        String beginWord,
        Map<String, List<String>> parents) {

        if (word.equals(beginWord)) {

            List<String> sequence = new ArrayList<>(path);

            Collections.reverse(sequence);

            result.add(sequence);

            return;
        }

        if (!parents.containsKey(word)) {
            return;
        }

        for (String parent : parents.get(word)) {

            path.add(parent);

            dfs(parent, beginWord, parents);

            path.remove(path.size() - 1);
        }
    }
}