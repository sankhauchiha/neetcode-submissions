class Solution {
    public int lastStoneWeight(int[] stones) {
         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones){
            pq.add(i);
        }


        while (pq.size() >= 2){
            int y = pq.remove();
            int x = pq.remove();

            if(y-x>0){
                pq.add((y-x));
            }
        }
        if(pq.size() == 0) return 0;
        return pq.poll();
    }
}
