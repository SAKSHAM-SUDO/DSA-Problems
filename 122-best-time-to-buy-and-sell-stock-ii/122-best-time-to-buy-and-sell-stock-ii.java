class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        for(int i = 0; i < dp.length; i++)
        {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return rec(0, prices, 1, dp);
    }
    public int rec(int i, int prices[], int canBuy, int dp[][])
    {
        if(i == prices.length)
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
            profit = Math.max(prices[i] + rec(i + 1, prices, 1, dp),
                             0 + rec(i + 1, prices, 0, dp));
        }
        
        return dp[i][canBuy] = profit;
    }
}