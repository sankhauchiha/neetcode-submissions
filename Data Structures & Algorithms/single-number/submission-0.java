class Solution {
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for(int i = 1, n = nums.length; i < n ; i++){
            ans = ans ^ nums[i];
        }
        return ans;
    }
}
