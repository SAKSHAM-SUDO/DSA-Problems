class Solution {
    public int minCostClimbingStairs(int[] cost)
    {
        
        int zero = calc(cost, 0, new int[cost.length]);
        int first = calc(cost, 1, new int[cost.length]);
        
        return Math.min(zero, first);
    }
    public int calc(int cost[], int idx, int dp[])
    {
        if(idx >= cost.length)
            return 0;
        
        if(dp[idx] > 0)
            return dp[idx];
        
        dp[idx] = cost[idx] + Math.min(calc(cost, idx + 1, dp),calc(cost, idx + 2, dp));
        return dp[idx];
    }
}