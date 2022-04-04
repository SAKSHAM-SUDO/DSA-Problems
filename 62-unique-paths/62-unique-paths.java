class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int rows[] : dp)
        {
            Arrays.fill(rows, -1);
        }
        int count = getPaths(0, 0, m, n, dp);
        return count;
    }
    public int getPaths(int row, int col, int m, int n, int dp[][])
    {
        if(row == m-1 && col == n-1)
        {
            return 1;
        }
        if(row >= m || col >= n)
        {
            return 0;
        }
        if(dp[row][col] != -1)
        {
            return dp[row][col];
        }
        int right = getPaths(row, col+1, m, n, dp);
        int down = getPaths(row+1, col, m, n, dp);
        return dp[row][col]=right+down;
    }
}