class Solution
{
    int mod = (int)(Math.pow(10, 9) + 7);
    int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startCol)
    {
        int memo[][][] = new int[m][n][maxMove + 1];
        
        for(int dp[][] : memo)
        {
            for(int row[] : dp)
            {
                Arrays.fill(row, -1);
            }
        }
        int ans = rec(m, n, maxMove, startRow, startCol, memo);
        return ans;
    }
    public int rec(int m, int n, int maxMoves, int startRow, int startCol, int dp[][][])
    {
        if(startRow < 0 || startCol < 0 || startRow >= m || startCol >= n)
        {
            return 1;
        }
            
        
        if(maxMoves == 0)
        {
            return 0;
        }
        
        if(dp[startRow][startCol][maxMoves] != -1)
            return dp[startRow][startCol][maxMoves];
        
        int total = 0;
        for(int i = 0; i < 4; i++)
        {
            int rowDash = startRow + dir[i][0];
            int colDash = startCol + dir[i][1];
            
            total = (total + rec(m, n, maxMoves - 1, rowDash, colDash, dp)) % mod;
            dp[startRow][startCol][maxMoves] = total;
        }
        return dp[startRow][startCol][maxMoves];
    }
}