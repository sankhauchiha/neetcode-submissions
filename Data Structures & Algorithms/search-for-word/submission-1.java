class Solution {
    public boolean exist(char[][] board, String word) {
        char first = word.charAt(0);
        boolean[][] visited = new boolean[board.length][board[0].length];
        String remaining = word.substring(1,word.length());

        for(int i = 0, n = board.length; i < n; i++){
            for(int j = 0, m = board[0].length; j < m; j++){
                if(board[i][j] == first){
                    visited[i][j] = true;
                    if(findWord(board, remaining, i, j, visited)){
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    boolean findWord(char[][] board, String word, int r, int c, boolean[][] visited){
        if(word.equals("")) return true;

        String remaining = word.substring(1, word.length());
        if(r > 0){
            if(board[r-1][c] == word.charAt(0) && !visited[r-1][c]){
                visited[r-1][c] = true;
                if(findWord(board, remaining, r-1,c, visited)) return true;
                visited[r-1][c] = false;
            }
        }

        if(r < board.length-1){
            if(board[r+1][c] == word.charAt(0) && !visited[r+1][c]){
                visited[r+1][c] = true;
                if(findWord(board, remaining, r+1,c, visited)) return true;
                visited[r+1][c] = false;
            }
        }

        if(c > 0){
            if(board[r][c-1] == word.charAt(0) && !visited[r][c-1]){
                visited[r][c-1] = true;
                if(findWord(board, remaining, r,c-1, visited)) return true;
                visited[r][c-1] = false;
            }
        }

        if(c < board[0].length-1){
            if(board[r][c+1] == word.charAt(0) && !visited[r][c+1]){
                visited[r][c+1] = true;
                if(findWord(board, remaining, r,c+1, visited)) return true;
                visited[r][c+1] = false;
            }
        }
        return false;
    }

}
