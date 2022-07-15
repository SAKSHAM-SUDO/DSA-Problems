public class Solution
{
    int total;
    public int findTargetSumWays(int[] nums, int S)
    {
        total  = 0;
        for(int n : nums)
            total += n;
        
        int[][] memo = new int[nums.length][2 * total + 1];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        int count = calculate(nums, 0, 0, S, memo);
        return count;
    }
    
    public int calculate(int[] nums, int i, int sum, int S, int memo[][])
    {
        if (i == nums.length)
        {
            if (sum == S)
            {
                return 1;
            }
            else
                return 0;
        }
        else if(memo[i][sum + total] != Integer.MIN_VALUE)
                return memo[i][sum + total];
        
        int add = calculate(nums, i + 1, sum + nums[i], S, memo);
        int subtract = calculate(nums, i + 1, sum - nums[i], S, memo);
        
        memo[i][sum + total] = add + subtract;
        return memo[i][sum + total];
    }
}