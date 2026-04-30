class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0, currEnd = 0, furthestEnd = 0;
        for(int i = 0; i < n - 1; i++){
            furthestEnd = Math.max(furthestEnd, nums[i] + i);
            if(i == currEnd){
                jumps++;
                currEnd = furthestEnd;
            }
        }
        return jumps;
    }
}
