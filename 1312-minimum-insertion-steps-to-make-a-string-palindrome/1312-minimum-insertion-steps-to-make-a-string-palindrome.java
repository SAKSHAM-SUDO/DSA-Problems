class Solution
{
    public int minInsertions(String s)
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
        return size - dp[size][size];
    }
//     public int rec(String s, String rev, int idx1, int idx2, int dp[][])
//     {
//         if(idx1 < 0 || idx2 < 0)
//             return 0;
        
//         int match = 0;
//         int notMatch = 0;
        
//         if(dp[idx1][idx2] != -1)
//             return dp[idx1][idx2];
        
//         if(s.charAt(idx1) == rev.charAt(idx2))
//         {
//             match = 1 + rec(s, rev, idx1 - 1, idx2 - 1, dp);
//         }
//         else
//         {
//           notMatch = Math.max(rec(s, rev, idx1 - 1, idx2, dp), rec(s, rev, idx1, idx2 -                   1, dp));
//         }
            
//         dp[idx1][idx2] = Math.max(match, notMatch);
//         return dp[idx1][idx2];
//     }
}