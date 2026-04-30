class Solution {
    public boolean canPartition(int[] nums) {
        int n = sum(nums);
        if(n%2 == 1){
             return false;
        }
        int target = n/2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);

        for(int i = nums.length-1; i >=0; i--){
            Set<Integer> newdp = new HashSet<>(dp);
            for(int j : dp){
                if(j+nums[i] == target){
                    return true;
                } 
                newdp.add(j+nums[i]);
            }
            dp = newdp;
        }
        return false;
    }

    private static int sum(int[] arr){
        int res = 0;
        for(int i : arr){ res+= i; }
        return res;
    }
}
