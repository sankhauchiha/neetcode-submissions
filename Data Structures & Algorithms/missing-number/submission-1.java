class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        for(int i = 0, n = nums.length; i < n ; i++ ){
            res += nums[i] - (i+1);
        }
        return  Math.abs(res);
    }
}
