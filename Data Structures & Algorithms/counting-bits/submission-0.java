class Solution {
    public int[] countBits(int n) {
     int[] res = new int[n+1];
     res[0] = 0;

     for(int i = 1; i <=n; i++){
        int temp = i;
        while(temp!=0){
            temp = temp&(temp-1);
            res[i]++;
        }
     }

    return res;    
    }
}
