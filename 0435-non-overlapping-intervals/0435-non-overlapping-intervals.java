class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int count=0;
        int le=Integer.MIN_VALUE;
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]>=le){
                le=intervals[i][1];

            }
            else{
                count++;
            }
        }
        return count;
    }
}