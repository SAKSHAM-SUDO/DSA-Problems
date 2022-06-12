class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = nums[0];
        int sum = nums[0];
        map.put(nums[0], 1);
        int j= 0;
        for(int i = 1; i < nums.length; i++)
        {
            if(map.containsKey(nums[i]))
            {
                while(map.containsKey(nums[i]) && j < i)
                {
                    map.remove(nums[j]);
                    sum -= nums[j];
                    j++;
                }
            }
            
            map.put(nums[i], 1);
            sum += nums[i];
            max = Math.max(sum, max);
        }
        return max;
    }
}