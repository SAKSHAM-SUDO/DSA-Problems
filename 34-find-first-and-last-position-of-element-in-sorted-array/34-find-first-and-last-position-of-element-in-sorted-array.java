class Solution {
    public int[] searchRange(int[] nums, int target)
    {
        // if(nums.length == 0)
        //     return new int[] {-1, -1};
        
        int i = 0; 
        int j = nums.length - 1;
        
        while(i <= j)
        {
            if(i < nums.length && nums[i] != target)
                i++;
            if(j >= 0 && nums[j] != target)
                j--;
            
            if(i < nums.length && j >= 0 && nums[i] == target && nums[j] == target)
                break;
        }
        
        if(i < nums.length && j >= 0 && nums[i] == target && nums[j] == target)
            return new int[] {i, j};
        
        else return new int[] {-1, -1};
            
        
    }
}