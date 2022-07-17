class Solution
{
    public int minInsertions(String s)
    {
        int len = s.length();
        String rev = "";
        int dp[][] = new int[len][len];
        
        for(int i = 0; i < len; i++)
        {
            char ch = s.charAt(i);
            rev = ch + rev;
        }
        for(int row[] : dp)
            Arrays.fill(row, -1);
        
        int lps = rec(s, rev, len - 1, len - 1, dp);
        return len - lps;
    }
    public int rec(String s, String rev, int idx1, int idx2, int dp[][])
    {
        if(idx1 < 0 || idx2 < 0)
            return 0;
        
        int match = 0;
        int notMatch = 0;
        
        if(dp[idx1][idx2] != -1)
            return dp[idx1][idx2];
        
        if(s.charAt(idx1) == rev.charAt(idx2))
        {
            match = 1 + rec(s, rev, idx1 - 1, idx2 - 1, dp);
        }
        else
        {
          notMatch = Math.max(rec(s, rev, idx1 - 1, idx2, dp), rec(s, rev, idx1, idx2 -                   1, dp));
        }
            
        
        dp[idx1][idx2] = Math.max(match, notMatch);
        return dp[idx1][idx2];
    }
}