class Solution {
    private boolean f(int i, int j, int n, int m, String s, String p, int[][] dp) {
        if (j == m) return i == n;
        if(dp[i][j] != -1) return dp[i][j] == 1 ? true : false;

        char c = p.charAt(j);
        boolean currentMatch = (i < n) && (s.charAt(i) == c || c == '.');
        boolean res = false;

        if (j + 1 < m && p.charAt(j + 1) == '*')
            res = res || f(i, j + 2, n, m, s, p, dp) || (currentMatch && f(i + 1, j, n, m, s, p, dp));
        else
            res = res || currentMatch && f(i + 1, j + 1, n, m, s, p, dp);

        dp[i][j] = res ? 1 : 0;
        return res;
    }

    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] d : dp) Arrays.fill(d, -1);
        return f(0, 0, n, m, s, p, dp);
    }
}
