class Solution {
   class Tuple{
        int nd, dst;
        Tuple(int n, int d){ nd = n; dst = d; }
    }
    class Pair{
        int dst;
        int nd,st;
        Pair(int d, int n, int s){ dst = d; nd = n; st=s;  }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Tuple>> adj = new ArrayList<>();
        for(int i =0; i<n; i++) adj.add(i, new ArrayList<>());
        for(int[] conn : flights) adj.get(conn[0]).add(new Tuple(conn[1], conn[2]));

        int[] dis = new int[n];
        Arrays.fill(dis, (int)1e9);
        dis[src] = 0;

        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(0,src,0));

        while (!q.isEmpty()){
            Pair p =q.remove();
            int wt = p.dst;
            int node = p.nd;
            int steps = p.st;

            if(steps > k) continue;
            for(Tuple i : adj.get(node)){
                if(wt + i.dst < dis[i.nd] && steps <= k){
                    dis[i.nd] = wt + i.dst;
                    q.add(new Pair(wt+i.dst, i.nd, steps+1));
                }
            }
        }
        if(dis[dst] == (int)1e9) return -1;
        return dis[dst];
    }
}
