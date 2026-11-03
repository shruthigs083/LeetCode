class Solution {
    public boolean validPath(int n, int[][] edges, int s, int d) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            int u= e[0];
            int v=e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        if(s==d){
            return true;
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        visited[s]=true;
        q.offer(s);
        while(!q.isEmpty()){
            int node=q.poll();
            if(node==d){
                return true;
            }
            for(int ni:adj.get(node)){
                if(!visited[ni]){
                q.offer(ni);
                visited[ni]=true;
            }
            }

        }
       return false; 
    }
}