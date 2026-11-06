class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int parent[]=new int[n+1];
        for(int i=1;i<n;i++){
            parent[i]=i;
        }
        for(int[] edge:edges){
            int a=edge[0];
            int b=edge[1];
            int Ra=root(parent,a);
            int Rb=root(parent,b);
            if(Ra==Rb){
                return edge;
            }
            parent[Rb]=Ra;
        }
        return new int[0];
    }
    private int root(int[]p,int a){
        if(p[a]==a){
            return a;
        }
       return root(p,p[a]);
    }
}