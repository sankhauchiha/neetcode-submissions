class Solution {
    public String longestPalindrome(String s) {
        String res = "";

        for(int i =0, n = s.length(); i < n ; i++){
            int left = i, right = i;
            while(left>=0 && right < n && s.charAt(left) == s.charAt(right)) {
                if(right-left+1 > res.length()){ res = s.substring(left, right+1); }
                left--; right++;
            }

            left = i; right = i+1;
            while(left>=0 && right < n && s.charAt(left) == s.charAt(right)) {
                if(right-left+1 > res.length()){ res = s.substring(left, right+1); }
                left--; right++;
            }
        }

        return res;
    }
}