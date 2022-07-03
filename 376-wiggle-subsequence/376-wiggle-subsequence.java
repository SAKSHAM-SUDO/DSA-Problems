class Solution {
    public int wiggleMaxLength(int[] nums) {
        
        if(nums.length == 0) {
            return 0;
        }
        
        if(nums.length == 1 || (nums.length == 2 && nums[0] != nums[1])) {
            return nums.length;
        }

        int dp[][] = new int[nums.length][2];
        for(int row[] : dp)
        {
            Arrays.fill(row, -1);
        }
        int p = count(nums, 1, 0, dp);
        int c = count(nums, 1, 1, dp);
        return 1 + (int)Math.max(p, c);
    }
    public int count(int nums[], int idx, int pos, int dp[][])
    {
        if(idx >= nums.length)
            return 0;
        
        if(dp[idx][pos] != -1)
            return dp[idx][pos];
        
        if(pos == 1)
        {
            if(nums[idx - 1] < nums[idx])
            {
                dp[idx][pos] = 1 + count(nums, idx + 1, 0, dp);
                return dp[idx][pos];
            }
                
            else
            {
                dp[idx][pos] =  count(nums, idx + 1, 1, dp);
                return dp[idx][pos];
            }
        }
        else
        {
            if(nums[idx - 1] > nums[idx])
            {
                dp[idx][pos] =  1 + count(nums, idx + 1, 1, dp);
                return dp[idx][pos];
            }
            else
            {
                dp[idx][pos] = count(nums, idx + 1, 0, dp);
                return dp[idx][pos];
            }
            
        }
    }
}