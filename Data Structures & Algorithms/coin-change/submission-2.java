class Solution {
    int maxInt = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        int[] arr = new int[amount+1];
        Arrays.fill(arr, -1);
        arr[0] = 0;

        for(int i = 0; i <= amount; i++){
            if(arr[i] != -1){
                for(int j : coins){
                    if(j != maxInt){
                        if(j+i<=amount){
                        if(arr[i+j] != -1){ arr[i+j] = Math.min(arr[i] + 1, arr[i+j]); }
                        else{ arr[i+j] = arr[i] + 1; } 
                       } 
                    }
                }
            }
        }

        return arr[amount];
    }
}
