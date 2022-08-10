class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
        {
            return 0;
        }
        int longestStreak = 1;
        int currentStreak = 1;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] == nums[i-1])
                continue;
            if(nums[i] == nums[i-1] + 1)
            {
                currentStreak++;
            }
            else{
                longestStreak = Math.max(currentStreak, longestStreak);
                currentStreak = 1;
            }
        }
        return Math.max(currentStreak, longestStreak);
    }
}