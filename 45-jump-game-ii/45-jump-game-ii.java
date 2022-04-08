class Solution {
		public int jump(int[] nums) {
            int dp[] = new int[nums.length];
            for(int i=nums.length-2;i>=0;i--)
            {
                int min=Integer.MAX_VALUE;
                for(int j=i+1;j<=i+nums[i] && j<nums.length;j++)
                {
                    if(dp[j] < min)
                    {
                        min = dp[j];
                    }
                }
                if(min != Integer.MAX_VALUE)
                {
                    dp[i] = 1 + min;
                }
                else
                    dp[i] = Integer.MAX_VALUE;
            }
            return dp[0];
	}

}
