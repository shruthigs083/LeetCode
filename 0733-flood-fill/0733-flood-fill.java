class Solution {
    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        int oc=grid[sr][sc];
        if(oc==color){
            return grid;
        }
        bfs(grid,sr,sc,oc,color);
        return grid;
    }
    private void bfs(int[][]grid,int sr,int sc,int oc, int c){
        grid[sr][sc]=c;
        int n=grid.length;
        int dr[]={-1,1,0,0};
        int dc[]={0,0,-1,1};
        for(int d=0;d<4;d++){
            int nr=sr+dr[d];
            int nc=sc+dc[d];
            if(nr>=0&&nr<n&&nc>=0&&nc<grid[0].length&&grid[nr][nc]==oc){
                bfs(grid,nr,nc,oc,c);
            }
        }
    }
}