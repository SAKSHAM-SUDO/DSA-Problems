class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // int dp[][][] = new int[n][2][k+1];
        // for (int[][] array2D: dp)
        // {
        //     for (int[] array1D: array2D)
        //     {
        //         Arrays.fill(array1D, -1);
        //     }
        // }
        // int ans = rec(0, prices, 1, k, dp);
        // return ans;
        
        
        int dp[][][] = new int[n + 1][2][k+1];
        for(int idx = n-1; idx >= 0; idx--)
        {
            for(int buy = 0; buy < 2; buy++)
            {
                for(int cap = 1; cap <= k; cap++)
                {
                    int profit = 0;
                    if(buy == 1)
                    {
                        profit = Math.max(-prices[idx] + dp[idx + 1][0][cap],
                                         0 + dp[idx + 1][1][cap]);
                    }
                    else{
                        profit = Math.max(prices[idx] + dp[idx + 1][1][cap - 1],
                                         0 + dp[idx + 1][0][cap]);
                    }
                    dp[idx][buy][cap] = profit;
                }
            }
        }
       return dp[0][1][k];
    }
    // public int rec(int idx, int[] prices, int buy, int cap, int dp[][][])
    // {
    //     if(cap == 0)
    //     {
    //         return 0;
    //     }
    //     else if(idx == prices.length)
    //     {
    //         return 0;
    //     }
    //     if(dp[idx][buy][cap] != -1)
    //     {
    //         return dp[idx][buy][cap];
    //     }
    //     int profit = 0;
    //     if(buy == 1)
    //     {
    //         profit = Math.max(-prices[idx] + rec(idx + 1, prices, 0, cap, dp),
    //                          0 + rec(idx + 1, prices, 1, cap, dp));
    //     }
    //     else{
    //         profit = Math.max(prices[idx] + rec(idx + 1, prices, 1, cap - 1, dp),
    //                          0 + rec(idx + 1, prices, 0, cap, dp));
    //     }
    //     dp[idx][buy][cap] = profit;
    //     return profit;
    // }
    
    
    // public int rec(int idx, int[] prices, int buy, int cap)
    // {
    //     if(cap == 0)
    //     {
    //         return 0;
    //     }
    //     else if(idx == prices.length)
    //     {
    //         return 0;
    //     }
    //     int profit = 0;
    //     if(buy == 1)
    //     {
    //         profit = Math.max(-prices[idx] + rec(idx + 1, prices, 0, cap),
    //                          0 + rec(idx + 1, prices, 1, cap));
    //     }
    //     else{
    //         profit = Math.max(prices[idx] + rec(idx + 1, prices, 1, cap - 1),
    //                          0 + rec(idx + 1, prices, 0, cap));
    //     }
    //     return profit;
    // }

}