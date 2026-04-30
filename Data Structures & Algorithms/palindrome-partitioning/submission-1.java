class Solution {
    public List<List<String>> partition(String s) {
        List<List<String >> sol = new ArrayList<>();
        List<String > buffer = new ArrayList<>();
        findAllSubstrings(s,0, buffer, sol);
        return sol;
    }

    boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length()-1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; 
            }
            left++;
            right--;
        }
        return true; 
    }


    void findAllSubstrings(String str, int index, List<String> currCom, List<List<String>> sol) {
        int length = str.length();
        if(index >= length){
            sol.add(new ArrayList<>(currCom));
            return;
        }

        for(int i = index; i<length; i++){
            String s = str.substring(index,i+1);
            if(isPalindrome(s)){
                currCom.add(s);
                findAllSubstrings(str, i+1, currCom, sol);
                currCom.remove(currCom.size()-1);
            }
        }
    }

}
