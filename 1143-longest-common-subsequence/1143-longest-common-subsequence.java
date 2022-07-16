class Solution {
    public int longestCommonSubsequence(String text1, String text2)
    {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];
                
        for(int i = 1; i <= text1.length(); i++)
        {
            for(int j = 1; j <= text2.length(); j++)
            {
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                
                if(text1.charAt(i - 1) == text2.charAt(j - 1))
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else 
                {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[text1.length()][text2.length()];
    }
//     public int rec(String text1, String text2, int idx1, int idx2, int dp[][])
//     {
//         if(idx1 < 0 || idx2 < 0)
//             return 0;
        
//         if(dp[idx1][idx2] != -1)
//             return dp[idx1][idx2];
//         if(text1.charAt(idx1) == text2.charAt(idx2))
//         {
//             dp[idx1][idx2] = 1 + rec(text1, text2, idx1 - 1, idx2 - 1, dp);
//             return dp[idx1][idx2];
//         }
            
        
//         else 
//         {
//             dp[idx1][idx2] = Math.max(rec(text1, text2, idx1 - 1, idx2, dp), rec(text1, text2, idx1, idx2 - 1, dp));
//             return dp[idx1][idx2];
//         }
//     }
}