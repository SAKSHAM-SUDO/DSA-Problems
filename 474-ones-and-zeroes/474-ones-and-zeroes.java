class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(int k = 0; k < strs.length; k++){
            int zero = 0, one = 0;
            for(char ch : strs[k].toCharArray()){
                if(ch == '0'){
                    zero++;
                }else{
                    one++;
                }
            }
            for(int i = m; i>= zero; i--){
                for(int j = n; j >= one; j--){
                    dp[i][j] = Math.max(dp[i - zero][j - one] + 1, dp[i][j]);
                }
            }
        }
        
        return dp[m][n];
    }
}
