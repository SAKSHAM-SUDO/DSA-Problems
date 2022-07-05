class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int max = 1;
        int curr = 1;
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i-1] == nums[i])
                continue;
            else if(nums[i-1] + 1 == nums[i])
                curr++;
            else
            {
                max = Math.max(max, curr);
                curr = 1;
            }
        }
        return Math.max(max, curr);
    }
}