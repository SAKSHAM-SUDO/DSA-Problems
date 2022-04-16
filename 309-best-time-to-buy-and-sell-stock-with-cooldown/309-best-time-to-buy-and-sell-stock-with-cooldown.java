class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n + 2][2];
        // for(int i = 0; i < n; i++)
        // {
        //     dp[i][0] = -1;
        //     dp[i][1] = -1;
        // }
        // return rec(0, prices, 1, dp);
        // dp[n][0] = 0;
        // dp[n][1] = 0;
        for(int i = n - 1; i >= 0; i--)
        {
            for(int j = 0; j < 2; j++)
            {
                int profit = 0;
                if(j == 1)
                {
                    profit = Math.max(-prices[i] + dp[i + 1][0],
                                      0 + dp[i + 1][1]);
                }
                else{
                    profit = Math.max(prices[i] +  dp[i + 2][1],
                                     0 + dp[i + 1][0]);
                }
                dp[i][j] = profit; 
            }
        }
        return dp[0][1];
    }
//     public int rec(int i, int prices[], int canBuy)
//     {
//         if(i >= prices.length)
//         {
//             return 0; // profit is zero
//         }
//         int profit = 0;
//         if(canBuy == 1)
//         {
//             profit = Math.max(-prices[i] + rec(i + 1, prices, 0) ,
//                               0 + rec(i + 1, prices, 1));
//         }
//         else{
//             profit = Math.max(prices[i] + rec(i + 2, prices, 1),
//                              0 + rec(i + 1, prices, 0));
//         }
        
//         return profit;
//     }

//     public int rec(int i, int prices[], int canBuy, int dp[][])
//     {
//         if(i >= prices.length)
//         {
//             return 0; // profit is zero
//         }
//         if(dp[i][canBuy] != -1)
//             return dp[i][canBuy];
//         int profit = 0;
//         if(canBuy == 1)
//         {
//             profit = Math.max(-prices[i] + rec(i + 1, prices, 0, dp) ,
//                               0 + rec(i + 1, prices, 1, dp));
//         }
//         else{
//             profit = Math.max(prices[i] + rec(i + 2, prices, 1, dp),
//                              0 + rec(i + 1, prices, 0, dp));
//         }
        
//         return dp[i][canBuy] = profit;
//     }
}