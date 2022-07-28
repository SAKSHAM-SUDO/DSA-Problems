class Solution {
    public int[] productExceptSelf(int[] nums)
    {
        int size = nums.length;
        int productRight[] = new int[size];
        int productLeft[] = new int[size];
        
        productRight[size - 1] = 1;
        productLeft[0] = 1;
        
        for(int i = 1; i < size; i++)
        {
            productLeft[i] = productLeft[i - 1] * nums[i - 1];
        }
        
        for(int i = size - 2; i >= 0; i--)
        {
            productRight[i] = productRight[i + 1] * nums[i + 1];
        }
        
        int ans[] = new int[size];
        for(int i = 0; i < size; i++)
        {
            ans[i] = productLeft[i] * productRight[i];
        }
        return ans;
    }
}