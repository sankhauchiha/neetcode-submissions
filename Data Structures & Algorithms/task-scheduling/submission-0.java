class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> m = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(char c : tasks){
            int count = 0;
            if(m.containsKey(c)){
                count = count + m.get(c);
            }
            count++;
            m.put(c,count);
        }

        for(int i : m.values()){
            pq.add(i);
        }
        
        int cycles = 0;
        while(!pq.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();

            for(int i = 0; i <=n ; i++){
                if(!pq.isEmpty()){
                    temp.add(pq.remove());
                }
            }

            for(int c : temp){
                int count = c - 1;
                if(count > 0){
                    pq.add(count);
                }
            }

            if(pq.isEmpty()){
                cycles = cycles + temp.size();
            }else {
                cycles= cycles + (n+1);
            }
        }

        return cycles;
    }
}