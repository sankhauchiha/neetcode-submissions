class Solution {
   public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> l = new ArrayList<>();
        queens(board,0, l);
        return l;
    }

    private void queens(boolean[][] board, int row, List<List<String>> l){
        if(row == board.length){
            display(board,l);
            return;
        }

        // placing the queen for each row and col, thus checking if possible
        for(int i = 0, n = board[0].length; i < n ; i++){
            if(isSafeQs(board, row, i)){
                board[row][i] = true;
                queens(board, row+1, l);
                board[row][i] = false;
            }
        }
    }

    private boolean isSafeQs(boolean[][] board, int row, int col){
        for(int i = 0 ; i < row; i++){
            if(board[i][col]){return false;}
        }

        int maxLeftMove = Math.min(row,col);
        int maxRightMove = Math.min(row,board[0].length-1-col);

        for(int i = 1; i<=maxLeftMove; i++){
            if(board[row-i][col-i]){return false;}
        }
        for(int i = 1; i<=maxRightMove; i++){
            if(board[row-i][col+i]){return false;}
        }
        return true;
    }

    private void display(boolean[][] board, List<List<String>> l){
        List<String> list = new ArrayList<>();
        for(boolean[] row: board){
            String str = "";
            for(boolean e : row){
                if(e){ str = str.concat("Q"); }
                else{ str = str.concat("."); }
            }
            list.add(str);
        }
        l.add(list);
    }
}
