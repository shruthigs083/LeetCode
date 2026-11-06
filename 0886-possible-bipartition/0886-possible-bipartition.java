class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        //BUILD THE GRAPH 
        List<List<Integer>>graph=new LinkedList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge:dislikes){
            int u=edge[0];
            int v=edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        //APPLY THE BIPARTION LOGIC 
        //-1=nocolor,0-1stcolor,1-2ndcolor
        int col[]=new int[n+1];
        Arrays.fill(col,-1);
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(col[i]==-1){
                col[i]=0;
                q.offer(i);
            }
            while(!q.isEmpty()){
                int u=q.poll();
                for(int v:graph.get(u)){
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