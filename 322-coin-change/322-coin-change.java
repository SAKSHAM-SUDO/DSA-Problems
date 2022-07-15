class Solution {
    public int coinChange(int[] coins, int amount)
    {
        if(amount == 0)
            return 0;
        int dp[][] = new int[coins.length][amount + 1];
        
        for(int row[] : dp)
            Arrays.fill(row, -1);
        
        int ans = rec(coins, coins.length - 1, amount, dp);
        
        if(ans == (int)Math.pow(10, 9))
            return -1;
        return ans;
    }
    public int rec(int coins[], int idx, int amount, int dp[][])
    {        
        if(idx == 0)
        {
            if(amount % coins[0] == 0)
            {
                dp[idx][amount] = (amount / coins[0]);
                return dp[idx][amount];
            }
            else
            {
                dp[idx][amount] = (int)Math.pow(10, 9);
                return dp[idx][amount];
            }
        }
        else if(dp[idx][amount] != -1)
            return dp[idx][amount];

        int pick = (int)Math.pow(10, 9);
        int notPick;
        
        notPick = 0 + rec(coins, idx - 1, amount, dp);
        if(coins[idx] <= amount)
            pick = 1 + rec(coins, idx, amount - coins[idx], dp);
        
        dp[idx][amount] = Math.min(pick, notPick);
        
        return dp[idx][amount];
    }
}