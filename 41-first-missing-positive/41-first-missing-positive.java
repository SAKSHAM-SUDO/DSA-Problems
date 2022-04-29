class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int l =0;
        
        while(l < nums.length)
        {
            if(nums[l] <= 0)
            {
                l++;
            }
            else
            {
                int correct = nums[l] - 1;
                if(nums[l] < nums.length && nums[l] != nums[correct])
                {
                    int temp = nums[l];
                    nums[l] = nums[correct];
                    nums[correct] = temp;
                }
                else
                    l++;
            }
        }
        
        for(int i = 0; i<nums.length; i++)
        {
            if(nums[i] != i+1)
                return i+1;
        }
        return nums.length + 1;
    }
}