class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        double N = Math.abs((double)n);
        while(N>0){
            if(N%2 == 1){
                ans = ans * x;
                N--;
            }
            else{
                N = N / 2;
                x = x * x;
            }
        }
        if(n < 0) return 1/ans;
        return ans;
    }
}
