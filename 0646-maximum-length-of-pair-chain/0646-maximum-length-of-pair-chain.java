class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->Integer.compare(a[1],b[1]));
        int count=0;
        int le=pairs[0][1];
        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0]>le){
                count++;
                le=pairs[i][1];
            }
        }
        return count+1 ;
    }
}