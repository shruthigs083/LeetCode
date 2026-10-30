class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length==0){
            return 0;
        }
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int a=1;
        int le=points[0][1];
        for(int i=1;i<points.length;i++){
            if(le<points[i][0]){
                a++;
                le=points[i][1];
            }
        }
        return a;

    }
}