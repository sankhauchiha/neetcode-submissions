class Solution {
    Map<String, Integer> hm = new HashMap<>();
    public int numDecodings(String s) {
        return printNum(s);
    }

    int printNum(String s){
        if(hm.containsKey(s)){ return hm.get(s); }
        int n = s.length();
        if(n == 0){
            return 1;
        }

        int le = 0, ri = 0;
        if(s.charAt(0) != '0'){
            le = printNum(s.substring(1,n));
        }

        if(n >= 2){
            String s1 = s.substring(0,2);
            if(Integer.parseInt(s1) <= 26 && Integer.parseInt(s1) > 9){
                ri = printNum(s.substring(2,n));
            }
        }

        hm.put(s,le+ri);
        return le+ri;
    }
}
