class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int dp[] = new int[nums.length];
        int sum = 0;
        for(int i = 2; i < nums.length; i++)
        {
            int prev1 = nums[i-1];
            int prev2 = nums[i-2];
            
            if(nums[i] - prev1 == prev1 - prev2)
            {
                dp[i] = dp[i-1] + 1;
                sum = sum + dp[i];
            }
        }
        return sum;
    }
}