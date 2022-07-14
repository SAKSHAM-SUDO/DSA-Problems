class Solution {
    public boolean canPartition(int[] nums)
    {
        int sum = 0;
        for(int n : nums)
            sum+= n;
        if(sum % 2 == 1)
            return false;
        
        boolean dp[][] = new boolean[nums.length][sum/2 + 1];
        for(int i = 0; i < nums.length; i++)
        {
            dp[i][0] = true;
        }
        if(nums[0] <= sum/2)
        dp[0][nums[0]] = true;
        for(int i = 1; i < dp.length; i++)
        {
            for(int j = 1;j < dp[0].length; j++)
            {
                boolean notTake = dp[i - 1][j];
                boolean take = false;
                if(nums[i] <= j)
                    take = dp[i - 1][j - nums[i]];
                dp[i][j] = take | notTake ;                
            }
        }
        return dp[dp.length - 1][sum/2];
    }
//     public boolean rec(int nums[], int idx, int target,Boolean dp[][])
//     {
//         if(idx == 0)
//             return target == nums[0];
        
//         else if(target < 0)
//             return false;
        
//         else if(target == 0)
//         {
//             dp[idx][target] = true;
//             return true;
//         }
            
//         else if(dp[idx][target] != null)
//             return dp[idx][target];
        
//         dp[idx][target] = rec(nums, idx - 1, target - nums[idx], dp) || rec(nums, idx - 1, target,                                                                                              dp);
//         return dp[idx][target];
//     }
}