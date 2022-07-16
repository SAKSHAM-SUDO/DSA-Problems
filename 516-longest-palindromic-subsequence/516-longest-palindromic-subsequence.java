class Solution {
    public int longestPalindromeSubseq(String s)
    {
        String rev = "";
        for (int i=0; i<s.length(); i++)
        {
            char ch= s.charAt(i); 
            rev= ch + rev; 
        }

        int size = s.length();
        int dp[][] = new int[size + 1][size + 1];
        
        for(int i = 1; i <= size; i++)
        {
            for(int j = 1; j <= size; j++)
            {
                if(s.charAt(i - 1) == rev.charAt(j - 1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                
                else 
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[size][size];
    }
}