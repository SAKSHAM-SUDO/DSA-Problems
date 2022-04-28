class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        int mask ;
        int sum;
        for(int i = 0; i < 32; i++)
        {
            mask = (1 << i);
            sum = 0;
            for(int j = 0; j < nums.length; j++)
            {
                if((mask & nums[j]) != 0)
                {
                    sum++;
                }
            }
            if(sum % 3 != 0)
            {
                ans = ans | mask;
            }
        }
        return ans;
    }
}