class Solution {
    public int countSubstrings(String s) {
        int conunt = 0;
        for(int i =0, n = s.length(); i < n ; i++){
            int left = i, right = i;
            while(left>=0 && right < n && s.charAt(left) == s.charAt(right)) {
                conunt++;
                left--; right++;
            }

            left = i; right = i+1;
            while(left>=0 && right < n && s.charAt(left) == s.charAt(right)) {
                conunt++;
                left--; right++;
            }
        }
        return conunt;
    }
}
