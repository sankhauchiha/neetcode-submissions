class Solution {
    private int f(int i, int j, int[] nums, int[][] dp){
       if(dp[i][j] != -1) return dp[i][j];

       int cn = 0;
       for(int k = i; k <= j; k++){
        cn = Math.max(cn, nums[k]*nums[i-1]*nums[j+1] + f(i, k - 1, nums, dp) + f(k + 1, j, nums, dp));
       }

       return dp[i][j] = cn;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] new_nums = new int[n + 2];
        new_nums[0] = 1;
        new_nums[n+1] = 1;
        for(int i = 1; i <= n; i++)
            new_nums[i] = nums[i-1];

        int[][] dp = new int[n+2][n+2];
        for(int[] d : dp) Arrays.fill(d, -1);

        return f(1, n, new_nums, dp);
    }
}
