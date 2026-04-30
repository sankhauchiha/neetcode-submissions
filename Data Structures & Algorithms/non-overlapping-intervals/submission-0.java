class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int ct = 0, lastmeeting = Integer.MIN_VALUE;
        for(int[] interval : intervals){
            if(interval[0] >= lastmeeting){
                lastmeeting = interval[1];
            }else{
                ct++;
            }
        }
        return ct;
    }
}
