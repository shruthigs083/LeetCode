class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int state[]=new int[n];
        List<Integer> safe=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(dfs(i,state,graph)){
                safe.add(i);
            }
        }
        return safe;

    }
    private Boolean dfs(int i,int[]state,int[][]g){
        if(state[i]==1){
            return false;
        }
        if(state[i]==2){
            return true;
        }
        state[i]=1;
        for(int n:g[i]){
            if(!dfs(n,state,g)){
                return false;
            }
        }
        state[i]=2;
        return true;

    }
}