class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int row[] : dp)
        {
            Arrays.fill(row, -1);
        }
        int count = rec(m - 1, n - 1, dp);
        return count;
    }
    public int rec(int m, int n, int dp[][])
    {
        if(m == 0 && n == 0)
            return 1;
        else if(m < 0 || n < 0)
            return 0;
        
        if(dp[m][n] != -1)
            return dp[m][n];
        
        int left = rec(m-1, n, dp);
        int right = rec(m, n-1, dp);
        
        dp[m][n] = left + right;
        return dp[m][n];
    }
}