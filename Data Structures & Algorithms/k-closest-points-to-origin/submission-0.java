class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer,ArrayList<int[]>> mp =new HashMap<>();

        for(int[] i : points){
            int n = i[0]*i[0] + i[1]*i[1];
            pq.add(n);
            ArrayList<int[]> ar = new ArrayList<>();
            if(mp.containsKey(n)){
                ar = mp.get(n);
            }
            ar.add(i);
            mp.put(n,ar);
        }


        for(int i = 0 ; i < k ; i++){
            if(mp.get(pq.peek()).size() > 1){
                ans[i] = mp.get(pq.peek()).get(1);
                i++;
            }
            ans[i] = mp.get(pq.remove()).get(0);
        }

        return ans;

    }
}
