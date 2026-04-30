class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) q.add(new int[] { i, j });
            }
        }
        if (q.size() == 0) return;
        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];
            for (int[] dir : dirs) {
                int x = row + dir[0];
                int y = col + dir[1];
                if (
                    x >= m ||
                    y >= n ||
                    x < 0 ||
                    y < 0 ||
                    grid[x][y] != Integer.MAX_VALUE
                ) continue;
                q.add(new int[] { x, y });

                grid[x][y] = grid[row][col] + 1;
            }
        }
    }
}

