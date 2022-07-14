class Solution {
    public boolean canPartition(int[] nums)
    {
        int sum = 0;
        for(int n : nums)
            sum+= n;
        if(sum % 2 == 1)
            return false;
        
        Boolean dp[][] = new Boolean[nums.length + 1][sum/2 + 1];
        
        return rec(nums, nums.length - 1, sum / 2, dp);
    }
    public boolean rec(int nums[], int idx, int target,Boolean dp[][])
    {
        if(idx == 0)
            return target == nums[0];
        
        else if(target < 0)
            return false;
        
        else if(target == 0)
        {
            dp[idx][target] = true;
            return true;
        }
            
        else if(dp[idx][target] != null)
            return dp[idx][target];
        
        dp[idx][target] = rec(nums, idx - 1, target - nums[idx], dp) || rec(nums, idx - 1, target,                                                                                              dp);
        return dp[idx][target];
    }
}