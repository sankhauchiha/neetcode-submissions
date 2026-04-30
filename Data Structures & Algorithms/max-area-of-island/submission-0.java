class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int area =0;
        int rows=grid.length;
        int cols=grid[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    area = Math.max(area, dfs(grid,i,j));
                }
            }
        }
        return area;
    }

    public int dfs(int [][] grid,int i,int j){
        int area = 0;
        int rows=grid.length;
        int cols=grid[0].length;

        if(i<0||i>=rows||j<0||j>=cols||grid[i][j]==0){ return area; }
        grid[i][j]=0;
        area++;

        area += dfs(grid,i-1,j);
        area += dfs(grid,i+1,j);
        area += dfs(grid,i,j-1);
        area += dfs(grid,i,j+1);

        return area;
    }
}




