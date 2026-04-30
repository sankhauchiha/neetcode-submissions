class Solution {
    private class Pair{
        String s;
        int dst;
        Pair(String x, int t){ s = x;  dst = t; }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> s = new HashSet<>();
        for(String str : wordList){
            s.add(str);
        }
        s.remove(beginWord);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        while(!q.isEmpty()){
            int dst = q.peek().dst;
            String word = q.remove().s;
            if(word.equals(endWord)) return dst;

            for(int i = 0, n = word.length(); i < n; i++){
                for(char c = 'a'; c <='z'; c++){
                    char[] replacecharArray = word.toCharArray();
                    replacecharArray[i] = c;
                    String replacedWord = new String(replacecharArray);
                    if(s.contains(replacedWord)){
                        s.remove(replacedWord);
                        q.add(new Pair(replacedWord, dst+1));
                    }
                }
            }
        }
        return 0;
    }
}
