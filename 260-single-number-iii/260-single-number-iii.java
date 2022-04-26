class Solution {
    public int[] singleNumber(int[] nums) {
        int res = 0;
        int ans[] = new int[2];
        int n = nums.length;
        for(int i = 0; i < n; i++)
        {
            res = res ^ nums[i];
        }
        int mask = res & -res;
        int x = 0; 
        int y = 0;
        
        for(int i = 0; i < n; i++)
        {
            if((nums[i] & mask) == 0)
            {
                x = x ^ nums[i];
            }
            else{
                y = y ^ nums[i];
            }
        }
        ans[0] = x;
        ans[1] = y;
        return ans;
    }
}