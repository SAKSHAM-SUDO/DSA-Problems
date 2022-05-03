class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int sort[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
        {
            sort[i] = nums[i];
        }
        Arrays.sort(sort);
        int start = nums.length, end = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] != sort[i])
            {
                start = Math.min(i, start);
                end = Math.max(i, end);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }
}