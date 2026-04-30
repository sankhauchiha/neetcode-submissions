class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(i, new ArrayList<>());
        for(int[] conn : edges){
            adj.get(conn[0]).add(conn[1]);
            adj.get(conn[1]).add(conn[0]);
        }

        boolean[] visited = new boolean[n];
        int ct = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                ct++;
                dfs(i, adj, visited);
            }
        }
        return ct;
    }

    private void dfs(int start, List<List<Integer>> l, boolean[] visited){
        if(!visited[start]){
            visited[start] = true;
            for(int i : l.get(start)){
                dfs(i, l, visited);
            }
        }
    }
}
