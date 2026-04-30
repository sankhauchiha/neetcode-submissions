class Solution {
    public int uniquePaths(int m, int n) {
        int[][] maze = new int[m][n];
        Map<List<Integer> , Integer> mp = new HashMap<>();
        return findPaths(0, 0, maze, mp);   
    }

    private int findPaths(int r, int c, int[][] maze, Map<List<Integer> , Integer> mp){
        List<Integer> cod = new ArrayList<>();
        cod.add(r);
        cod.add(c);
        if(mp.containsKey(cod)) return mp.get(cod);
        if(r == maze.length-1 || c == maze[0].length-1) return 1;

        int bottom = findPaths(r+1, c, maze, mp);
        int right = findPaths(r, c+1, maze, mp);

        mp.put(cod, bottom+right);
        return bottom+right;
    }
}
