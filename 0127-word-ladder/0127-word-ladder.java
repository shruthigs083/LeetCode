class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Step 1: Convert wordList into HashSet
        Set<String> set = new HashSet<>(wordList);

        // Step 2: If endWord is absent, return 0
        if (!set.contains(endWord)) {
            return 0;
        }

        // Step 3: Initialize BFS
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int steps = 1;

        // Mark beginWord as visited
        set.remove(beginWord);

        // Step 4: BFS traversal
        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String word = queue.poll();

                // Convert word into StringBuilder
                StringBuilder sb = new StringBuilder(word);

                // Visit every character position
                for (int j = 0; j < word.length(); j++) {

                    char originalChar = sb.charAt(j);

                    // Try all 26 lowercase letters
                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        sb.setCharAt(j, ch);

                        String newWord = sb.toString();

                        // Check if destination is reached
                        if (newWord.equals(endWord)) {
                            return steps + 1;
                        }

                        // Check if word exists and is unvisited
                        if (set.contains(newWord)) {

                            queue.offer(newWord);

                            // Mark as visited
                            set.remove(newWord);
                        }
                    }

                    // Restore original character
                    sb.setCharAt(j, originalChar);
                }
            }

            // Move to next BFS level
            steps++;
        }

        return 0;
    }
}