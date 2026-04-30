class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0)
            return new int[][]{newInterval};

        List<int[]> list = new ArrayList<int[]>();
        boolean inserted = false;

        for (int i = 0; i < n; i++) {
            if (!inserted && intervals[i][0] >= newInterval[0]) {
                list.add(newInterval);
                inserted = true;
            }
            list.add(intervals[i]);
        }

        if (!inserted) {
            list.add(newInterval); // newInterval goes at the end
        }

        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < list.size(); i++) {
            int[] interval = list.get(i);
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                int[] last = merged.get(merged.size() - 1);
                last[1] = Math.max(last[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
