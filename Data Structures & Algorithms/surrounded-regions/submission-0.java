
class Solution {
    public void solve(char[][] board){
        if(board.length == 0 || board[0].length == 0) return;
        int rows = board.length;
        int cols = board[0].length;

        for(int j = 0; j < cols; j++){
            if(board[0][j] == 'O') dfsSolve(0, j, board);
            if(board[rows-1][j] == 'O') dfsSolve(rows-1, j, board);
        }
        for(int i = 0; i < rows ; i++){
            if(board[i][0] == 'O') dfsSolve(i, 0, board);
            if(board[i][cols-1] == 'O') dfsSolve(i, cols-1, board);
        }        

        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                if(board[r][c] == 'O') board[r][c] = 'X';
                if(board[r][c] == 'T') board[r][c] = 'O';
            }
        }
    }


    private void dfsSolve(int row, int col, char[][] board) {
        if(row<0 || col<0 || row==board.length || col==board[0].length 
                || board[row][col] !='O' ) return;
    
        board[row][col] = 'T';
        dfsSolve(row+1, col, board);
        dfsSolve(row, col+1, board);
        dfsSolve(row-1, col, board);
        dfsSolve(row, col-1, board);	
    }
}
