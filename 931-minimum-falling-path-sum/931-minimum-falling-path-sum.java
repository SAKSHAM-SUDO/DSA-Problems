class Solution {
    public int minFallingPathSum(int[][] matrix)
    {
        
        int minSum = Integer.MAX_VALUE;
        int r = matrix.length;
        int c = matrix[0].length;
        int dp[][] = new int[r][c];
        
        for(int row[] : dp)
            Arrays.fill(row, -1);
        
        for(int i = 0; i < matrix[0].length; i++)
        {
            int curSum = rec(matrix, r - 1, i, dp);
            minSum = Math.min(minSum, curSum);
        }
        return minSum;
    }
    public int rec(int[][] matrix, int row, int col, int dp[][])
    {
        if(col >= matrix[0].length || row < 0 || col < 0)
            return (int)Math.pow(10,9);
        
        else if(row == 0)
        {
            dp[row][col] = matrix[row][col];
            return dp[row][col];
        }
            
        
        else if(dp[row][col] != -1)
            return dp[row][col];
        
        int dLeft = matrix[row][col] + rec(matrix, row - 1, col - 1, dp);
        int dright = matrix[row][col] + rec(matrix, row - 1, col + 1, dp);
        int down = matrix[row][col] + rec(matrix, row - 1, col, dp);

        dp[row][col] = Math.min(dLeft, Math.min(dright, down));
        return dp[row][col];
    }
}