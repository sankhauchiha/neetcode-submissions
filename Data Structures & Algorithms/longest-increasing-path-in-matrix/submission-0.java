class Solution {
    private boolean isValid(int i, int j, int m, int n){
        return (i >= 0 && j >=0 && i < m && j <n);
    }

    private int f(int i, int j, int m, int n, int[][] matrix, int[][] dp){
        if(dp[i][j] != 0) return dp[i][j];
        int len = 1;

        if(isValid(i + 1, j, m, n) && matrix[i][j] > matrix[i + 1][j]){
            len = Math.max(len, 1 + f(i+1, j, m, n, matrix, dp)); 
        }
        if(isValid(i - 1, j, m, n) && matrix[i][j] > matrix[i - 1][j]){
            len = Math.max(len, 1 + f(i-1, j, m, n, matrix, dp)); 
        }
        if(isValid(i, j - 1, m, n) && matrix[i][j] > matrix[i][j - 1]){
            len = Math.max(len, 1 + f(i, j - 1, m, n, matrix, dp)); 
        }
        if(isValid(i, j + 1, m, n) && matrix[i][j] > matrix[i][j + 1]){
            len = Math.max(len, 1 + f(i, j + 1, m, n, matrix, dp)); 
        }

        return dp[i][j] = len;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int ln = 0;

        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                ln = Math.max(ln, f(i,j,m,n,matrix,dp));
            }
        }

        return ln;
    }
}
