class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int col[]=new int[n];
        //0 - 1st color
        //1 - 2nd color
        //-1 - no color
        for(int i=0;i<n;i++){
            col[i]=-1;
             }
    
    Queue<Integer> q=new LinkedList<>();
    for(int i=0;i<n;i++){
        if(col[i]==-1){
            col[i]=0;
            q.offer(i);
        }
    while(!q.isEmpty()){
        int u=q.poll();
        for(int v:graph[u]){
            if(col[v]==-1){
                col[v]=1-col[u];
                q.offer(v);
            }
            else if(col[v]==col[u]){
                return false;
            }
        }
    }
    }


    
    return true;
    }
}