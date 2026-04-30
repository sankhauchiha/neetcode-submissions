class Solution {
  public int climbStairs(int n){
        Map<Integer, Integer> l = new HashMap<>();
        return climbStairs(n, l);
    }

    int climbStairs(int n, Map<Integer, Integer> l) {
        if(l.containsKey(n)){ return l.get(n); }
        if(n == 0){ return 1; }

        int left = 0, right = 0;
        if(n >= 1){ left = climbStairs(n-1, l); }
        if(n >= 2){ right = climbStairs(n-2, l); }

        l.put(n, left+right);
        return left+right;
    }
}
