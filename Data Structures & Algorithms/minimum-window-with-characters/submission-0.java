class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> arr1 = new HashMap<>();
        HashMap<Character, Integer> arr2 = new HashMap<>();
        int m = s.length(), n = t.length();
        List<String> min = new ArrayList<>();

        for(int i = 0; i < n ; i++){
            int j = 0;
            char c = t.charAt(i);
            if(arr2.containsKey(c)){ j = arr2.get(c); }
            j++;
            arr2.put(c,j);
        }

        int l = 0;
        for(int r = 0; r < m ; r++){
            int j = 0;
            char c = s.charAt(r);
            if(arr1.containsKey(c)){ j = arr1.get(c); }
            j++;
            arr1.put(c,j);

            if(Equality(arr2, arr1)){
                while(Equality(arr2, arr1)){
                    c = s.charAt(l);
                    j = arr1.remove(c);
                    if(j > 1){
                        arr1.put(c, j-1);
                    }
                    l++;
                }
                min.add(s.substring(l-1,r+1));
            }
        }

        return findMinLengthString(min);
    }

    static boolean Equality(HashMap<Character, Integer> arr2, HashMap<Character, Integer> arr1){
        for(char c : arr2.keySet()){
            if(!arr1.containsKey(c)){ return false; }
            if(arr2.get(c) > arr1.get(c)){
                return false;
            }
        }
        return true;
    }

    static String findMinLengthString(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            return "";
        }
        String minLengthString = strings.get(0);

        for (String str : strings) {
            if (str.length() < minLengthString.length()) {
                minLengthString = str;
            }
        }
        return minLengthString;
    }
}
