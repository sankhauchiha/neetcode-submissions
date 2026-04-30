class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        int[][] dp = new int[n1+1][n2+1];

        for(int idx1 = 1; idx1<=n1; idx1++){
            for(int idx2 = 1; idx2<=n2; idx2++){
                if(text1.charAt(idx1-1) == text2.charAt(idx2-1))
                    dp[idx1][idx2] = 1 + dp[idx1-1][idx2-1];
                else
                    dp[idx1][idx2] =  Math.max(dp[idx1-1][idx2], dp[idx1][idx2-1]);
            }
        }

        return dp[n1][n2];
    }
}
