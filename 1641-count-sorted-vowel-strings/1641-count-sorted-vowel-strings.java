class Solution {
    public int countVowelStrings(int n) {
        // int count = 0;
        // count = calc(0, n, 0);
        // return count;
        int[][] dp=new int[n+1][6];
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=5;j++){
                dp[i][j]=dp[i][j-1]+(i>1?dp[i-1][j]:1);
            }
        }
        
        return dp[n][5];
    }
//     public int calc(int idx, int n, int count)
//     {
//         if(count == n)
//         {
//             return 1;
//         }
//         else if(count > n)
//             return 0;
        
//         int total = 0;
//         for(int i = idx; i < 5; i++)
//         {
//             total = total + calc(i, n, count + 1);
//         }
//         return total;
//     }
}