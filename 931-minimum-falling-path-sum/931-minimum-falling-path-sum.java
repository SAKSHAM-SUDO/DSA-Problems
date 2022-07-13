class Solution {
    public int minFallingPathSum(int[][] a) {
        int min = Integer.MAX_VALUE;
        int m = a.length;
        int n = a[0].length;
        
        int[][] dp=new int[m][n];
        for(int[] row: dp) Arrays.fill(row,-1);
        for(int j = 0; j<n; j++) dp[0][j] = a[0][j];
        
        for(int i = 1; i<m; i++){
            for(int j =0; j<n; j++){
                
                int left = a[i][j];
                if(j>0) left += dp[i-1][j-1];
                else left += (int)Math.pow(10,9);
                
                int up = a[i][j] + dp[i-1][j];
                
                int right = a[i][j];
                if(j<a[0].length-1) right += dp[i-1][j+1];
                else right = (int)Math.pow(10,9);
                
                dp[i][j] = Math.min(left,Math.min(up,right));
            }
        }
        
        for(int j = 0; j<n; j++){
            min = Math.min(min,dp[n-1][j]);
        }
        return min;
    }
}