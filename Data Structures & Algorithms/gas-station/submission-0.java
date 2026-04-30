class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGain = 0, currGain = 0, startIdx = 0;
        for(int i = 0; i < n; i++){
            int gain = gas[i] - cost[i];
            totalGain += gain;
            currGain += gain;

            if(currGain < 0){
                startIdx = i + 1;
                currGain = 0;
            }
        }
        
        return totalGain >= 0 ? startIdx : -1;
    }
}
