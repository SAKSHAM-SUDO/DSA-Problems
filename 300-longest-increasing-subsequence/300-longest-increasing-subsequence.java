class Solution {
    public int lengthOfLIS(int[] nums)
    {
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[0]);
        
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] > ans.get(ans.size() - 1))
            {
                ans.add(nums[i]);
            }
            else
            {
                int index = binarySearch(nums[i], ans);
                ans.set(index, nums[i]);
            }
        }
        return ans.size();
    }
    
    public int binarySearch(int num, List<Integer> list)
    {
        int low = 0;
        int high = list.size() - 1;
        
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            
            if(list.get(mid) == num)
                return mid;
            
            else if(list.get(mid) > num)
                high = mid - 1;
            
            else
                low = mid + 1;
        }
        return low;
    }
}