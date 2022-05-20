class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r  = obstacleGrid.length;
        int c  = obstacleGrid[0].length;
        // for(int rows[] : dp)
        // {
        //     Arrays.fill(rows, -1);
        // }
        // int count = getPaths(0, 0, r, c, obstacleGrid, dp);
        // return count;
        
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                if(i == 0 && j == 0 && obstacleGrid[i][j] == 0)
                {
                    obstacleGrid[i][j] = 1;
                }
                else if(obstacleGrid[i][j] == 1)
                {
                    obstacleGrid[i][j] = 0;
                }
                else{
                    int left = 0;
                    int up = 0;
                    if(j - 1 >= 0)
                        left = obstacleGrid[i][j-1];
                    if(i - 1 >= 0)
                        up = obstacleGrid[i-1][j];
                    obstacleGrid[i][j] = left+ up;
                }
            }
        }
        return obstacleGrid[r-1][c-1];
    }
    // public int getPaths(int i, int j, int r, int c, int grid[][], int dp[][])
    // {
    //     if(i == r-1 && j == c - 1)
    //     {
    //         if(grid[r-1][c-1] == 1)
    //         return 0;
    //         else
    //             return 1;
    //     }
    //     else if(i >= r || j >= c)
    //     {
    //         return 0;
    //     }
    //     else if(grid[i][j] == 1)
    //     {
    //         return 0;
    //     }
    //     else if(dp[i][j] != -1)
    //     {
    //         return dp[i][j];
    //     }
    //     int right = getPaths(i, j + 1, r, c, grid, dp);
    //     int down = getPaths(i + 1, j, r, c, grid, dp);
    //     dp[i][j] = down + right;
    //     return dp[i][j];
    // }
}