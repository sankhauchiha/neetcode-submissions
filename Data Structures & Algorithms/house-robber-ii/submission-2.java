class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){ return nums[0]; }
        
        int first = 0, second = 0;
        for(int  i = 0; i <n-1; i++ ){
            int temp = Math.max(first + nums[i], second);
            first = second;
            second = temp;
        }

        int r = second;
        first = 0; second = 0;
        for(int  i = 1; i <n; i++ ){
            int temp = Math.max(first + nums[i], second);
            first = second;
            second = temp;
        }
        return Math.max(r,second);
    }
}
