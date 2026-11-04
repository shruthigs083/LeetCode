class Solution {
    public int numEnclaves(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int count=0;
        for(int i=0;i<row;i++){
            if(grid[i][0]==1){
                dfs(i,0,grid,row,col);
            }
            if(grid[i][col-1]==1){
                dfs(i,col-1,grid,row,col);
            }
        }
        for(int j=0;j<col;j++){
            if(grid[0][j]==1){
                dfs(0,j,grid,row,col);
            }
            if(grid[row-1][j]==1){
                dfs(row-1,j,grid,row,col);
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(int r, int c ,int[][]grid ,int row,int col){
        grid[r][c]=0;
        int dr[]={-1,1,0,0};
        int dc[]={0,0,-1,1};
        for(int d=0;d<4;d++){
            int nr=r+dr[d];
            int nc=c+dc[d];
            if(nr>=0&&nr<row&&nc>=0&&nc<col&&grid[nr][nc]==1){
                dfs(nr,nc,grid,row,col);
            }
        }
    }
}