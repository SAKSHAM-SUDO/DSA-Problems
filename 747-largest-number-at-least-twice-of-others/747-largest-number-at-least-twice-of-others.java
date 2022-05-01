class Solution {
    public int dominantIndex(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return 0;
        int max1 = 0;
        int max2 = 0;
        int mx1 = Integer.MIN_VALUE;
        int mx2 = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++)
        {
            if(nums[i] > mx1)
            {
                max2 = max1;
                mx2 = mx1;
                mx1 = nums[i];
                max1 = i;
            }
            else if(nums[i] > mx2)
            {
                mx2 = nums[i];
                max2 = i;
            }
        }
        if(mx1 >= 2 * mx2)
            return max1;
        else
            return -1;
    }
}