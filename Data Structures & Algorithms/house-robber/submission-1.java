class Solution {
    public int rob(int[] nums) {
        int first = 0, second = 0;
        for(int  i : nums){
            int temp = Math.max(first + i, second);
            first = second;
            second = temp;
        }

        return second;
    }
}
