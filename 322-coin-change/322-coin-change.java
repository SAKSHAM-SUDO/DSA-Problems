class Solution {
    public int coinChange(int[] coins, int amount)
    {
        if(amount == 0)
            return 0;
        int dp[] = new int[amount + 1];        
        
        for(int i = 0; i <= amount; i++)
        dp[i] = i % coins[0] == 0 ? (i / coins[0]) : (int)Math.pow(10, 9);
        
        for(int i = 1; i < coins.length; i++)
        {
            int curr[] = new int[amount + 1];
            for(int target = 0; target <= amount; target++)
            {
                
                int pick = (int)Math.pow(10, 9);
                int notPick = 0;

                notPick = 0 + dp[target];
                if(coins[i] <= target)
                    pick = 1 + curr[target - coins[i]];
                curr[target] = Math.min(pick, notPick);
            }
            dp = curr;
        }
        
        if(dp[amount] == (int)Math.pow(10, 9))
            return -1;
        return dp[amount];
    }
//     public int rec(int coins[], int idx, int amount, int dp[][])
//     {        
//         if(idx == 0)
//         {
//             if(amount % coins[0] == 0)
//             {
//                 dp[idx][amount] = (amount / coins[0]);
//                 return dp[idx][amount];
//             }
//             else
//             {
//                 dp[idx][amount] = (int)Math.pow(10, 9);
//                 return dp[idx][amount];
//             }
//         }
//         else if(dp[idx][amount] != -1)
//             return dp[idx][amount];

//         int pick = (int)Math.pow(10, 9);
//         int notPick;
        
//         notPick = 0 + rec(coins, idx - 1, amount, dp);
//         if(coins[idx] <= amount)
//             pick = 1 + rec(coins, idx, amount - coins[idx], dp);
        
//         dp[idx][amount] = Math.min(pick, notPick);
        
//         return dp[idx][amount];
//     }
}