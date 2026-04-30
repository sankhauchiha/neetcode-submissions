class Solution {
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
        int n = str.length();
        int start = 0, end = n-1;
        while(start < n/2){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;end--;
        }
       return true;
    }
}
