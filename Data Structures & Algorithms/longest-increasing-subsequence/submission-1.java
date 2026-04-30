class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] LIS = new int[n];
        Arrays.fill(LIS, 1);

        for(int i = n-1; i>=0 ; i--){
            for(int j = i+1; j < n; j++){
                if(nums[i] < nums[j]){
                    LIS[i] = Math.max(LIS[i], LIS[j]+1);
                }
            }
        }

        return findMax(LIS);
    }

    private int findMax(int[] array) {
        int max = array[0];
        for (int i : array) {
            if (i > max) max = i; 
        }
        return max;
    }
}
