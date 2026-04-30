class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] arr = new boolean[n+1];
        arr[0] = true;
        for(int i = 0 ; i <= n ; i++){
            if(arr[i]){
                for(String word : wordDict){
                    int m = word.length();
                    if(i+m<=n && word.equals(s.substring(i,i+m))){ arr[i+m] = true; }
                }
            }
        }
        return arr[n];
    }
}
