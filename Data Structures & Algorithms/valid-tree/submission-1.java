class Solution {
    class Pair{
        int currNode, dst;
        Pair(int x, int y){ currNode = x;  dst =y;  }
    }

    public boolean validTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<n; i++) adj.add(i, new ArrayList<>());
        for(int[] conn : edges){
            adj.get(conn[0]).add(conn[1]);
            adj.get(conn[1]).add(conn[0]);
        }

        boolean[] visited = new boolean[n];
        if(checkCycle(adj, visited, 0)) return false;
        for(int i = 0; i < n; i++){
            if(!visited[i]) return false;
        }
        return true;
    }

    private boolean checkCycle(ArrayList<ArrayList<Integer>> l, boolean[] visited, int src){
        visited[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,-1));

        while (!q.isEmpty()){
            Pair p = q.remove();
            int curr = p.currNode;
            int prev = p.dst;

            for(int i  : l.get(curr)){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(new Pair(i, curr));
                }
                else if (i!=prev){ return true; }
            }
        }
        return false;
    }
}
