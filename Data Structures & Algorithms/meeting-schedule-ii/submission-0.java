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
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Integer> lastMeet = new PriorityQueue<>();
        for (Interval interval : intervals) {
            if(lastMeet.isEmpty()) {
                lastMeet.add(interval.end);
                continue;
            }

            if(lastMeet.peek() <= interval.start) 
                lastMeet.poll();
            lastMeet.add(interval.end);
        }
        return lastMeet.size();
    }
}
