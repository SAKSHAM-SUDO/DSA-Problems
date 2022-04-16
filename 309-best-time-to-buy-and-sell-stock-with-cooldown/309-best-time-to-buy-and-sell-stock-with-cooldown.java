class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int i = 0; i < n; i++)
        {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return rec(0, prices, 1, dp);
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

    public int rec(int i, int prices[], int canBuy, int dp[][])
    {
        if(i >= prices.length)
        {
            return 0; // profit is zero
        }
        if(dp[i][canBuy] != -1)
            return dp[i][canBuy];
        int profit = 0;
        if(canBuy == 1)
        {
            profit = Math.max(-prices[i] + rec(i + 1, prices, 0, dp) ,
                              0 + rec(i + 1, prices, 1, dp));
        }
        else{
            profit = Math.max(prices[i] + rec(i + 2, prices, 1, dp),
                             0 + rec(i + 1, prices, 0, dp));
        }
        
        return dp[i][canBuy] = profit;
    }

}