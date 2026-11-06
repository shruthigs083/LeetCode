class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int row=grid2.length;
        int col=grid2[0].length;
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid2[i][j]==1){
                    if(dfs(i,j,grid2,grid1,row,col)){
                        count++;
                    }
                }
            }
        }
        return count;
        
    }
    private Boolean dfs(int r,int c,int[][] g2, int[][] g1,int row,int col){
        if(r<0||r>=row||c<0||c>=col||g2[r][c]==0){
            return true;
        }
        Boolean is=g1[r][c]==1;
        g2[r][c]=0;
        int dr[]={-1,1,0,0};
        int dc[]={0,0,-1,1};
        for(int d=0;d<4;d++){
            int nr=r+dr[d];
            int nc=c+dc[d];
            if(!dfs(nr,nc,g2,g1,row,col)){
                is=false;
            }
        }
        return is;
    }
}