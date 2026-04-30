class Solution {
    class Tuple{
    int r, c, dst;
    Tuple(int row, int col, int d){ r= row; c = col; dst = d; }
    }
    
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        return BFS(n-1,n-1,n,grid);
    }

    private int BFS(int r, int c, int n, int[][] grid){
        int[][] visited = new int[n][n];
        PriorityQueue<Tuple> q = new PriorityQueue<Tuple>((x,y) -> x.dst - y.dst);
        visited[r][c] = 1;
        q.add(new Tuple(r,c,grid[r][c]));

        int ct = 0;
        while (!q.isEmpty()){
            Tuple t = q.remove();
            int row = t.r , col = t.c;
            ct = Math.max(ct,t.dst);

            if(row == 0 && col == 0) break;
            int[] dr = {-1,1,0,0};
            int[] dc = {0,0,1,-1};
            for(int i = 0; i<4; i++){
                int newR = row + dr[i];
                int newC = col + dc[i];
                 if(isValid(newR, newC,n) && visited[newR][newC] == 0){
                     visited[newR][newC] = 1;
                     q.add(new Tuple(newR,newC,grid[newR][newC]));
                 }
            }
        }
        return ct;
    }

    private boolean isValid(int x, int y, int n){ return (x >=0 && y >=0 && x <n && y<n); }
}