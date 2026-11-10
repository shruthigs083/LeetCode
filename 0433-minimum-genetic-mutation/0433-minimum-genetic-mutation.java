
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {

        if (startGene.equals(endGene)) {
            return 0;
        }

        Set<String> set = new HashSet<>(Arrays.asList(bank));

        if (!set.contains(endGene)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        set.remove(startGene);

        int steps = 0;
        char[] genes = {'A', 'C', 'G', 'T'};

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String gene = queue.poll();

                if (gene.equals(endGene)) {
                    return steps;
                }

                StringBuilder sb = new StringBuilder(gene);

                for (int j = 0; j < gene.length(); j++) {

                    char original = sb.charAt(j);

                    for (char ch : genes) {

                        if (ch == original) {
                            continue;
                        }

                        sb.setCharAt(j, ch);
                        String newGene = sb.toString();

                        if (set.contains(newGene)) {
                            queue.offer(newGene);
                            set.remove(newGene);
                        }
                    }

                    sb.setCharAt(j, original);
                }
            }

            steps++;
        }

        return -1;
    }
}
