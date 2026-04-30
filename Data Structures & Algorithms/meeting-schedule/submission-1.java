/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);
        int lastMeet = -1;
        for (Interval interval : intervals) {
            if(interval.start < lastMeet) {
               return false;
            }
            lastMeet = interval.end;
        }
        return true;
    }
}
