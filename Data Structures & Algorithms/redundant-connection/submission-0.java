class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] par = new int[n+1];
        int[] rank = new int[n+1];
        for(int i = 0; i<=n; i++){
            par[i] = i;
            rank[i] = 1;
        }

        for(int[] conn : edges){
            int p1 = findParent(par, conn[0]);
            int p2 = findParent(par, conn[1]);

            if(p1 == p2) return conn;
            else if(p1 > p2){
                par[p2] = p1;
                rank[p1] += rank[p2];
            }else{
                par[p1] = p2;
                rank[p2] += rank[p1];
            }
        }
        return new int[]{0};
    }

    private int findParent(int[] par, int n){
        int p = par[n];
        while (p!=par[p]){
            par[p] = par[par[p]];
            p = par[p];
        }
        return p;
    }
}
