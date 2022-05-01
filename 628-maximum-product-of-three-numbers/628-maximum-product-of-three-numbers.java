class Solution {
    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++)
        {
            int n = nums[i];
            
            if(n < min1)
            {
                min2 = min1;
                min1 = n;
            }
            else if(n < min2)
            {
                min2 = n;
            }
            if(n > max1)
            {
                max3 = max2;
                max2 = max1;
                max1 = n;
            }
            else if(n > max2)
            {
                max3 = max2;
                max2 = n;
            }
            else if(n > max3)
            {
                max3 = n;
            }
        }
        int multiply1 = min1 * min2 * max1;
        int multiply2 = max1 * max2 * max3;
        return multiply1 > multiply2 ? multiply1 : multiply2;
    }
}