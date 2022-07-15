class Solution 
{
    int dir[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid)
    {
        int r = grid.length;
        int c = grid[0].length;
        boolean vis[][] = new boolean[r][c];
        int maxArea = 0;
        
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                if(grid[i][j] == 1 && vis[i][j] == false)
                {
                    int curArea = dfs(grid, i, j, vis);
                    maxArea = Math.max(curArea, maxArea);
                }
            }
        }
        return maxArea;
    }
    public int dfs(int grid[][], int row, int col, boolean vis[][])
    {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || vis[row][col] == true || grid[row]                                              [col] == 0)
            return 0;
        
        vis[row][col] = true;
        int curArea = 1;
        for(int i = 0; i < 4; i++)
        {
            int rowDash = dir[i][0] + row;
            int colDash = dir[i][1] + col;
            curArea += dfs(grid, rowDash, colDash, vis);
        }
        return curArea;
    }
}