class Solution {
    public int change(int amount, int[] coins)
    {
        int dp[][] = new int[coins.length][amount + 1];
        
        for(int row[] : dp)
            Arrays.fill(row, -1);
        
        return rec(coins, coins.length - 1, amount, dp);
    }
    public int rec(int coins[], int idx, int amount, int dp[][])
    {
        if(amount == 0)
        {
            dp[idx][amount] = 1;
            return 1;
        }
        
        if(idx == 0)
        {
            if(amount % coins[idx] == 0)
            {
                dp[idx][amount] = 1;
               return 1; 
            }
                
            else
            {
                dp[idx][amount] = 0;
                return 0;
            }
        }
        if(dp[idx][amount] != -1)
            return dp[idx][amount];
        
        int take = 0;
        int notTake = 0;
        notTake = rec(coins, idx - 1, amount, dp);
        if(amount >= coins[idx])
            take = rec(coins, idx, amount - coins[idx], dp);
        
        dp[idx][amount] = take + notTake;
        return dp[idx][amount];
    }
}