class Solution {
    public int uniquePaths(int m, int n)
    {
        int dp[][] = new int[m][n];
        
        for(int row[] : dp)
            Arrays.fill(row, -1);
        return rec(0, 0, m, n, dp);
    }
    public int rec(int row, int col, int m, int n, int dp[][])
    {
        if(row == m-1 && col == n-1)
            return 1;
        
        else if(row >= m || col >= n)
            return 0;
        
        else if(dp[row][col] != -1)
            return dp[row][col];
        
        dp[row][col] = rec(row + 1, col, m, n, dp) + rec(row, col + 1, m, n, dp);
        return dp[row][col];
    }
}