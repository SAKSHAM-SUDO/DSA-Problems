class Solution {
    public int singleNumber(int[] nums) {
        int p = 1;
        int ans = 0;
        for(int i = 0; i < 32; i++)
        {
            int one = 0; 
            int zero = 0;
            for(int j = 0; j < nums.length; j++)
            {
                if((p & nums[j]) != 0)
                {
                    one++;
                }
                else{
                    zero++;
                }
            }
            if(one % 3 == 1)
            {
                ans = ans + p;
            }
            p = p * 2;
        }
        return ans;
    }
}