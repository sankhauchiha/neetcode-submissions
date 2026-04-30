class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n == 0) return 0;
        if(n == 1) return cost[0];

        int first = cost[0], second = cost[1];
        for(int i = 2; i < n; i++){
            int temp = cost[i] + Math.min(first, second);
            first = second;
            second = temp;
        }

        return Math.min(first, second);
    }
}
