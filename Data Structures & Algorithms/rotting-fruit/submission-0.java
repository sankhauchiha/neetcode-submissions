class Solution {
   class Pair{
        int r, c;
        int time;
        Pair(int x, int y, int t){ r = x;  c =y;  time = t; }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int c = 0;
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                }
            }
        }
         c = floodFill(grid, q);
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    return-1;
                }
            }
        }
        return c;
    }

    private int floodFill(int[][] grid, Queue<Pair> q) {
        int  n = grid.length, m = grid[0].length;
        int t = 0;

        while (!q.isEmpty()){
            Pair p  = q.remove();
            int r = p.r, c = p.c;
            t = p.time;

            if(c + 1<m && grid[r][c+1] == 1){ 
                grid[r][c+1] = 2;
                q.add(new Pair(r,c+1, t+1));
            }
            if(c - 1>=0  && grid[r][c-1] == 1){ 
                grid[r][c-1] = 2;
                q.add(new Pair(r,c-1,t+1));
            }
            if(r - 1>=0 && grid[r-1][c] == 1){ 
                grid[r-1][c] = 2;
                q.add(new Pair(r-1,c,t+1));
            }
            if( r + 1<n && grid[r+1][c] == 1){ 
                grid[r+1][c] = 2;
                q.add(new Pair(r+1,c,t+1));
            }
        }
        return t;
    }
}
