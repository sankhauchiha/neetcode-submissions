class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<String, List<String>> mp = new HashMap<>();
        mp.put("2", Arrays.asList("a", "b", "c"));
        mp.put("3", Arrays.asList("d", "e", "f"));
        mp.put("4", Arrays.asList("g", "h", "i"));
        mp.put("5", Arrays.asList("j", "k", "l"));
        mp.put("6", Arrays.asList("m", "n", "o"));
        mp.put("7", Arrays.asList("p", "q", "r", "s"));
        mp.put("8", Arrays.asList("t", "u", "v"));
        mp.put("9", Arrays.asList("w", "x", "y", "z"));

        int n = digits.length();
        if(n == 0)  return new ArrayList<>();
        if(n == 1) return mp.get(digits);

        List<String> res = new ArrayList<>();
        List<String> combinations = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(res.isEmpty()){
                res.addAll(mp.get(digits.charAt(i) + ""));
                continue;
            }

            for(String str1 : res){
                for(String str2 : mp.get(digits.charAt(i) + "")){
                    combinations.add(str1 + str2);
                }
            }

            res = new ArrayList<>(combinations);
            combinations.removeAll(res);
        }

        return res;
        
    }
}
