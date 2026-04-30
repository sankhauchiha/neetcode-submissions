class Solution {
    class Pair{
        List<Integer> arr = new ArrayList<>();
        Pair(int x, int y){ arr.add(0,x); arr.add(1,y); }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
           int n = heights.length, m = heights[0].length;
           boolean[][] visitedAtlantic = new boolean[n][m];
           boolean[][] visitedPacific = new boolean[n][m];
           List<List<Integer>> res = new ArrayList<>();

           for(int i = 0; i < m ; i++){
               dfs(0,i,heights[0][i],heights, visitedPacific);
               dfs(n-1,i,heights[n-1][i],heights, visitedAtlantic);
           }
           for(int i = 0; i < n ; i++){
               dfs(i, 0, heights[i][0], heights, visitedPacific);
               dfs(i, m-1, heights[i][m-1], heights, visitedAtlantic);
           }
           for(int i = 0; i < n ; i ++){
               for(int j = 0; j < m; j++){
                  if(visitedAtlantic[i][j] && visitedPacific[i][j]){ res.add(new Pair(i,j).arr); }
               }
           }

           return res;
    }

    void dfs(int row, int col, int prevHeight, int[][] board, boolean[][] visited) {
           if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] || board[row][col] < prevHeight)
               return;
           visited[row][col] = true;
           int currHeight = board[row][col];
           dfs(row+1,col, currHeight, board, visited);
           dfs(row-1,col, currHeight, board, visited);
           dfs(row,col+1, currHeight, board, visited);
           dfs(row,col-1, currHeight, board, visited);
    }
}
