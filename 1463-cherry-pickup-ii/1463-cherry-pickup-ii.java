class Solution {
    public int cherryPickup(int[][] grid)
    {
        int r = grid.length;
        int c = grid[0].length;
        int dp[][][] = new int[r][c][c];
        
        for(int mat[][] : dp)
        {
            for(int row[] : mat)
            {
                Arrays.fill(row, -1);
            }
        }
        return rec(grid, 0, 0, grid[0].length - 1, dp);
    }
    public int rec(int grid[][], int i, int j1, int j2, int dp[][][])
    {
        if(j1 >= grid[0].length || j2 >= grid[0].length || j1 < 0 || j2 < 0)
            return -(int)Math.pow(10, 9);
        
        if(i == grid.length - 1)
        {
            if(j1 == j2)
            {
             dp[i][j1][j2] = grid[i][j1];
                return dp[i][j1][j2];
            }
            
            else
                dp[i][j1][j2] = grid[i][j1] + grid[i][j2];
                return dp[i][j1][j2];
        }
        if(dp[i][j1][j2] != -1)
            return dp[i][j1][j2];
        
        // explore all paths of bob and alice simultaneously
        int maxi = Integer.MIN_VALUE;
        for(int dj1 = -1; dj1 <= 1 ; dj1++)
        {
            for(int dj2 = -1; dj2 <= 1; dj2++)
            {
                int value = 0;

                if(j1 == j2)
                    value = grid[i][j1];
                else
                    value = grid[i][j1] + grid[i][j2];
                
                value += rec(grid, i + 1, j1 + dj1, j2 + dj2, dp);
                maxi = Math.max(maxi, value);
            }
        }
        dp[i][j1][j2] = maxi;
        return dp[i][j1][j2];
    }
}