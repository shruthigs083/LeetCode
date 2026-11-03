class Solution {
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int c=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    c++;
                    dfs(grid,i,j,row,col);

                }
            }
        }
        return c;
    }
    private void dfs(char[][]grid,int r,int c,int row,int col){
        grid[r][c]=0;
        int dr[]={-1,1,0,0};
        int dc[]={0,0,-1,1};
        for(int d=0;d<4;d++){
            int nr=r+dr[d];
            int nc=c+dc[d];
            if(nr>=0&&nr<row&&nc>=0&&nc<col&&grid[nr][nc]=='1'){
                dfs(grid,nr,nc,row,col);
            }
        }
    }
}