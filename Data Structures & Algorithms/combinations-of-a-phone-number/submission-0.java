class Solution {
    HashMap<String, List<String>> dial = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0){
            return res;
        }

        dial.put("2", Arrays.asList("a", "b", "c"));
        dial.put("3", Arrays.asList("d", "e", "f"));
        dial.put("4", Arrays.asList("g", "h", "i"));
        dial.put("5", Arrays.asList("j", "k", "l"));
        dial.put("6", Arrays.asList("m", "n", "o"));
        dial.put("7", Arrays.asList("p", "q", "r", "s"));
        dial.put("8", Arrays.asList("t", "u", "v"));
        dial.put("9", Arrays.asList("w", "x", "y", "z"));

        if(digits.length() == 1){
            return dial.get(digits);
        }

        List<String> buffer;
        List<String> store = new ArrayList<>();
        for(int i =0 ,n =digits.length(); i < n; i++){
            if(store.size() == 0){
                store.addAll(dial.get(digits.charAt(i)+""));
                continue;
            }
            buffer = dial.get(digits.charAt(i)+"");
            for(String a : store){
                for(String b : buffer){
                    res.add(a+b);
                }
            }
            store = new ArrayList<>(res);
            res.removeAll(store);
        }
        return store;
    }
}
