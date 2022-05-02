class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int leftProd[] = new int[n];
        int rightProd[] = new int[n];
        int ans[] = new int[n];
        leftProd[0] = nums[0];
        rightProd[n-1] = nums[n-1];
        for(int i = 1; i < n; i++)
        {            
            leftProd[i] = leftProd[i-1] * nums[i];
        }
        for(int i = n - 2; i >= 0; i--)
        {
            rightProd[i] = rightProd[i+1] * nums[i];
        }
        
        for(int i = 0; i < n; i++)
        {
            if(i == 0)
            {
                ans[i] = rightProd[i+1];
            }
            else if(i == n-1)
            {
                ans[i] = leftProd[i-1];
            }
            else
                ans[i] = leftProd[i-1] * rightProd[i+1];
        }
        return ans;
    }
}