class Solution {
    public int leastInterval(char[] tasks, int n) {
       int count[]=new int[26];
       for(char i:tasks){
        count[i-'A']++;
       } 
       Arrays.sort(count);
       int mf=count[25];
       int idle=(mf-1)*n;
       for(int i=24;i>=0;i--){
        idle-=Math.min(count[i],mf-1);
       }
       idle=Math.max(0,idle);
       return tasks.length+idle;

    }
}