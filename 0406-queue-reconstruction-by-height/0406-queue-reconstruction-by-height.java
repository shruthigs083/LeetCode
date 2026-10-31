class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->{
            if(a[0]==b[0]){
                return Integer.compare(a[1],b[1]);
            }
           return Integer.compare(b[0],a[0]);
    });
    List<int[]> result = new ArrayList<>();

        // Insert each person at their required position
        for (int[] person : people) {
            result.add(person[1], person);
        }

        return result.toArray(new int[result.size()][]);
    

    }
}