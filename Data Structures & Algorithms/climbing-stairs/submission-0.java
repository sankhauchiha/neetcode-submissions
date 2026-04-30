class Solution {
    public int climbStairs(int n) {
        if(n == 0){
            return 1;
        }

        int left = 0, right = 0;
        if(n >= 1){ left = climbStairs(n-1); }
        if(n >= 2){ right = climbStairs(n-2); }

        return left+right;
    }
}
