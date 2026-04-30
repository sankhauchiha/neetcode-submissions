class Solution {
    static Map<String, Boolean> memo = new HashMap<>();
    public String longestPalindrome(String s) {
        List<String> l = findAllSubstrings(s);
        String res = s.charAt(0)+"";
        for(String str : l){
            int n = str.length();
            if(n>1 && isPalindrome(str)){
                if(res.length()<n){
                    res = str;
                }
            }
        }

        return res;
    }

    static List<String> findAllSubstrings(String str) {
        List<String> substrings = new ArrayList<>();

        int n = str.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                substrings.add(str.substring(i, j));
            }
        }

        return substrings;
    }

    static boolean isPalindrome(String str){
        if(memo.containsKey(str)) { return memo.get(str); }
        int n = str.length();
        if(n<=1){ return true; }
        int s = 0, e = n-1;
        if(str.charAt(s) != str.charAt(e)){ return false; }

        String next = str.substring(1,e);
        boolean res = isPalindrome(next);
        memo.put(next, res);
        return res;
    }
}