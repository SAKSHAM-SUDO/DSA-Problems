class Solution {
    public int splitArray(int[] nums, int m) {
        int left = 0;
        int right = 0;
        
        for(int n : nums)
        {
            right += n;
        }
        while(left < right)
        {
            int mid = left + (right - left)/2;
            if(possible(nums, m, mid))
            {
                right = mid;
            }
            else
            {
                left = mid + 1;
            }
        }
        return right;
    }
    public boolean possible(int nums[], int m, int mid)
    {
        int n = 0;
        int currSum = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] > mid)
                return false;
            else if(currSum + nums[i] <= mid)
            {
                currSum = currSum + nums[i];
            }
            else
            {
                currSum = nums[i];
                n++;
            }
        }
        if(currSum != 0)
            n++;
        return n <= m;
    }
}