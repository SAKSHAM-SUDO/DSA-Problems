class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curSum = nums[0];
        
        for(int i = 1; i < nums.length; i++)
        {
            if(curSum < 0)
                curSum = nums[i];
            
            else
                curSum = curSum + nums[i];
            
            if(curSum > maxSum)
                maxSum = curSum;
        }
        return maxSum;
    }
}