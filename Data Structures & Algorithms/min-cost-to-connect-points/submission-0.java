class Solution {
    static class Pair{
        int currNode, dst;
        Pair(int x, int y){ currNode = x;  dst =y;  }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Map<int[], Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++) mp.put(points[i], i);

        List<List<List<Integer>>> adj = new ArrayList<>();
         for(int i = 0; i < n; i++){
            List<List<Integer>> l = new ArrayList<>();
            int[] inti = points[i];
            for(int[] point : points){
                if(point.equals(inti)) continue;
                List<Integer> cod = new ArrayList<>();
                cod.add(mp.get(point));
                cod.add(Math.abs(inti[0]- point[0]) + Math.abs(inti[1]- point[1]));
                l.add(cod);
            }
            adj.add(i,l);
        }

        int[] vis = new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.dst-y.dst);
        pq.add(new Pair(0, 0));

        int sum = 0;
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int node = p.currNode;
            int wt = p.dst;

            if(vis[node] == 1) continue;
            vis[node] = 1;
            sum += wt;

            for(List<Integer> l : adj.get(node)){
                int nei = l.get(0);
                int dis = l.get(1);
                if(vis[nei] == 0){
                    pq.add(new Pair(nei, dis));
                }
            }
        }
        return sum;
    }
}
