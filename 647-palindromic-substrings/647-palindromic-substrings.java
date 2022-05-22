class Solution {
    public int countSubstrings(String s) {
        
        boolean dp[][] = new boolean[s.length()][s.length()];
        
        for(int i=0;i<s.length();i++) {
            dp[i][i]=true;
        }
        int count=s.length();
        for(int len=2;len<=s.length();len++) {
            for(int i=0;i<=s.length()-len;i++) {
                int j = i+len-1;
                
                if(s.charAt(i)!=s.charAt(j)) {
                    dp[i][j]=false;
                }else {
                    if(len==2)
                        dp[i][j]=true;
                    else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                if(dp[i][j])
                    count++;
            }
        }
        return count;
    }
}
