class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int maxArea=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                int area=dfs(i,j,grid,row,col);
                maxArea=Math.max(maxArea,area);
                }
            }
        }
        return maxArea;
    }
    private int dfs(int r,int c,int[][]g,int row,int col){
        if(r<0||r>=row||c<0||c>=col||g[r][c]==0){
            return 0;
        }
        g[r][c]=0;
        int a=1;
        int dr[]={-1,1,0,0};
        int dc[]={0,0,-1,1};
        for(int d=0;d<4;d++){
            int nr=r+dr[d];
            int nc=c+dc[d];
            
            a=a+dfs(nr,nc,g,row,col);

        }
        return a;
    }
}