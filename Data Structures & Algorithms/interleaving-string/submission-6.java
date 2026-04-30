class Solution {
    private boolean f(int i, int j, String s1, String s2, String s3, int[][] dp){
        int n1 = s1.length(), n2 = s2.length();
        if(i == n1 && j == n2) return true;
        if(dp[i][j] != -1) return dp[i][j] == 1 ? true : false;

        boolean res = false;
        char c3 = s3.charAt(i+j);

        if(i < n1 && s1.charAt(i) == c3) res = res || f(i+1, j, s1, s2, s3, dp);
        if(j < n2 && s2.charAt(j) == c3) res = res || f(i, j+1, s1, s2, s3, dp);
        dp[i][j] = res ? 1 : 0;

        return res;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length();
        if(n1 + n2 != s3.length()) return false;
        int[][] dp = new int[n1 + 1][n2 + 1];
        for(int[] a : dp) Arrays.fill(a, -1);
        return f(0, 0, s1, s2, s3, dp);
    }
}
