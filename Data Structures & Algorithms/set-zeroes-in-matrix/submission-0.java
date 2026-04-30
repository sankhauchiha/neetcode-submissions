class Pair{
    int r, c;
    Pair(int r, int c){
        this.r = r;
        this.c = c;
    }
}

class Solution {
    public void setZeroes(int[][] matrix) {
       int m = matrix.length, n = matrix[0].length;
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0) q.add(new Pair(i, j));
            }
        }

        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.r;
            int c = p.c;
            for(int i = 0; i < n; i++){
                matrix[r][i] = 0;
            }
            for(int i = 0; i < m; i++){
                matrix[i][c] = 0;
            }
        }
    }
}