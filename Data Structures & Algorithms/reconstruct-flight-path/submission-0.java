class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> mp = new HashMap<>();
        for(List<String> ticket : tickets){
            String src = ticket.get(0);
            String dst = ticket.get(1);
            mp.putIfAbsent(src,new PriorityQueue<>());
            mp.get(src).add(dst);
        }
        DFS("JFK", mp);
        return ans;
    }

    private void DFS(String src, Map<String, PriorityQueue<String>> mp){
        while (mp.containsKey(src) && mp.get(src).size() > 0)
            DFS(mp.get(src).remove(), mp);
        ans.add(0,src);
    }
}
