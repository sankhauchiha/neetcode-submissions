class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i : hand){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(int key : map.keySet()){
            int ct = map.get(key);
            if(ct > 0){
                for(int i = 1; i < groupSize; i++){
                    int currKey = key + i;
                    if(map.getOrDefault(currKey, 0) < ct) return false;
                    map.put(currKey, map.get(currKey) - ct);
                }
            }
        }

        return true;
    }
}
