class Solution {
    public int[][] updateMatrix(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int row=grid.length;
        int col=grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                }
                else{
                    grid[i][j]=-1;
                }
            }
        }
        while(!q.isEmpty()){
            int dr[]={-1,1,0,0};
            int dc[]={0,0,-1,1};
            int size=q.size();
            for(int i=0;i<size;i++){
            int n[]=q.poll();
            int r=n[0];
            int c=n[1];
            for(int d=0;d<4;d++){
                int nr=r+dr[d];
                int nc=c+dc[d];
                if(nr>=0&&nr<row&&nc>=0&&nc<col&&grid[nr][nc]==-1){
                    grid[nr][nc]=grid[r][c]+1;
                    q.offer(new int[]{nr,nc});
                }

            }
            }

        }
        return grid;

    }
}