class Solution {
    public int wiggleMaxLength(int[] nums) {
        
        if(nums.length == 0) {
            return 0;
        }
        
        if(nums.length == 1 || (nums.length == 2 && nums[0] != nums[1])) {
            return nums.length;
        }

        int p = count(nums, 1, false);
        int c = count(nums, 1, true);
        return 1 + (int)Math.max(p, c);
    }
    public int count(int nums[], int idx, boolean pos)
    {
        if(idx >= nums.length)
            return 0;
        
        if(pos)
        {
            if(nums[idx - 1] < nums[idx])
                return 1 + count(nums, idx + 1, false);
            else
                return count(nums, idx + 1, true);
        }
        else
        {
            if(nums[idx - 1] > nums[idx])
                return 1 + count(nums, idx + 1, true);
            else
                return count(nums, idx + 1, false);
            
        }
    }
}