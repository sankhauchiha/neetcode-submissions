class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        
        for(int idx = n-1; idx >= 0; idx--){
            for(int buy = 0; buy<2; buy++){
                if(buy == 1)
                    dp[idx][buy] = Math.max(dp[idx][0]-prices[idx], dp[idx+1][1]);
                else
                    dp[idx][buy] = Math.max(dp[idx+2][1] + prices[idx], dp[idx+1][0]);
            }
        }

        return dp[0][1];
    }
}
