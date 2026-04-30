class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(minCostClimbingStairs(cost,0,0, new HashMap<>()), minCostClimbingStairs(cost,1,0, new HashMap<>()));
    }

    int minCostClimbingStairs(int[] cost, int index, int price, Map<Integer, Integer> list) {
//        if(list.containsKey(index)){ return list.get(index); }
        int n = cost.length;
        if(index ==  n){ return price; }

        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if(index+1 <= n){ left = minCostClimbingStairs(cost, index+1, price+cost[index], list); }
        if(index+2 <= n){ right = minCostClimbingStairs(cost, index+2, price+cost[index], list); }

        int res = Math.min(left,right);
//        list.put(index, res);
        return res;
    }
}
