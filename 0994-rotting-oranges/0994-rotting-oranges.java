class Solution {
    public int orangesRotting(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int fresh=0;
        int minutes=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }      
            }
        }
        int dr[]={-1,1,0,0};
        int dc[]={0,0,-1,1};
        while(!q.isEmpty()&&fresh>0){
            int size=q.size();
            
            for(int i=0;i<size;i++){
                int curr[]=q.poll();
                int r=curr[0];
                int c=curr[1];
                for(int d=0;d<4;d++){
                    int nr=r+dr[d];
                    int nc=c+dc[d];
                    if(nr>=0&&nr<row&&nc>=0&&nc<col&&grid[nr][nc]==1){
                        fresh--;
                        grid[nr][nc]=2;
                        q.offer(new int[]{nr,nc});

                    }
                    
                }
               
            }
           
             minutes++;
            
        }
        return fresh==0?minutes:-1;

    }
}