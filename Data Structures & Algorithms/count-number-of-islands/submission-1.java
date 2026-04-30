// class Solution {
//     public int numIslands(char[][] grid) {
//         int islands=0;
//         int rows=grid.length;
//         int cols=grid[0].length;

//         for(int i=0;i<rows;i++){
//             for(int j=0;j<cols;j++){
//                 if(grid[i][j]=='1'){
//                     islands++;
//                     dfs(grid,i,j);
//                 }
//             }
//         }
//         return islands;
//     }
//     public void dfs(char [][] grid,int i,int j){
//         int rows=grid.length;
//         int cols=grid[0].length;

//         if(i<0||i>=rows||j<0||j>=cols||grid[i][j]=='0'){
//             return;
//         }
//         grid[i][j]='0';

//         dfs(grid,i-1,j);
//         dfs(grid,i+1,j);
//         dfs(grid,i,j-1);
//         dfs(grid,i,j+1);
//     }
// }

class Solution {
     static class Pair{
        int r, c;
        Pair(int x, int y){ r = x; c =y; }
    }

    public int numIslands(char[][] grid) {
        int ct = 0;
        int  n = grid.length, m = grid[0].length;
        int[][] visited = new int[n][m];
        for(int i =0; i<n ; i++){
            for(int j = 0; j < m ; j++){
                if(visited[i][j]!=1 && grid[i][j] == '1'){
                    BFS(grid, visited, i, j);
                    ct++;
                }
            }
        }
        return ct;
    }


    public static void BFS(char[][] grid, int[][] visited, int sr, int sc){
        visited[sr][sc] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(sr,sc));
        int  n = grid.length, m = grid[0].length;

        while (!q.isEmpty()){
            Pair p  = q.remove();
            int r = p.r, c = p.c;

            if(c + 1<m && grid[r][c+1] == '1' && visited[r][c+1] != 1){
                visited[r][c+1] = 1;
                q.add(new Pair(r,c+1));
            }
            if(c - 1>=0  && grid[r][c-1] == '1' && visited[r][c-1] != 1){
                visited[r][c-1] = 1;
                q.add(new Pair(r,c-1));
            }
            if(r - 1>=0 && grid[r-1][c] == '1' && visited[r-1][c] != 1){
                visited[r-1][c] = 1;
                q.add(new Pair(r-1,c));
            }
            if( r + 1<n && grid[r+1][c] == '1' && visited[r+1][c] != 1){
                visited[r+1][c] = 1;
                q.add(new Pair(r+1,c));
            }
        }
    }
    
}
