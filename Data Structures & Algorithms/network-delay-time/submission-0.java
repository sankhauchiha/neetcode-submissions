class Solution {
     static class Pair{
        int currNode, dst;
        Pair(int x, int y){ currNode = x;  dst =y;  }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<List<Integer>>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for(int[] conn : times){
            int u = conn[0];
            int v = conn[1];
            int time = conn[2];
            List<Integer> l = new ArrayList<>();
            l.add(v); l.add(time);
            adj.get(u).add(l);
        }

        int[] dis = new int[n+1];
        Arrays.fill(dis, (int)1e9);
        dis[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.dst-y.dst);
        pq.add(new Pair(k, 0));

        while (!pq.isEmpty()){
            int u = pq.peek().currNode;
            int dst = pq.remove().dst;

            for(int i = 0, m=adj.get(u).size(); i < m; i++){
                int v = adj.get(u).get(i).get(0);
                int wt = adj.get(u).get(i).get(1);
                if(dst + wt < dis[v]){
                    dis[v] = dst + wt;
                    pq.add(new Pair(v, dis[v]));
                }
            }
        }

        int min = -1;
        for(int i = 1; i<=n; i++){
            if(dis[i] == (int)1e9){
                min = -1;
                break;
            }
            min = Math.max(min, dis[i]);
        }

        return min;
    }
}
