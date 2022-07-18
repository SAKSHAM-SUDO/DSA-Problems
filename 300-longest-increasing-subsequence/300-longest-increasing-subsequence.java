class Solution {
    public int lengthOfLIS(int[] nums)
    {
        int n = nums.length;
        int dp[][] = new int[n][n + 1];
        
        for(int row[] : dp)
            Arrays.fill(row, -1);
        
        return rec(nums, 0, -1, n, dp);
    }
    public int rec(int nums[], int idx, int prev, int n, int dp[][])
    {
        if(idx >= n)
        {
            return 0;
        }
        
        if(dp[idx][prev + 1] != -1)
            return dp[idx][prev + 1];
        
        int pick = 0;
        int notPick = 0;
                
        if(prev == -1 || nums[idx] > nums[prev])
            pick = 1 + rec(nums, idx + 1, idx, n, dp);

        notPick = rec(nums, idx + 1, prev, n, dp);
        
        dp[idx][prev + 1] = Math.max(pick, notPick);
        return dp[idx][prev + 1];
    }

}