class Solution {
    public int findMaxLength(int[] nums) {
        int length = 0;
        int arr[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
                arr[i] = -1;
            else
                arr[i] = nums[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i = 0; i < arr.length; i++)
        {
             sum += arr[i];
            if(map.containsKey(sum))
            {
                length = Math.max(length, i - map.get(sum));
            }
            else
            {
                map.put(sum, i);
            }
        }
        return length;
    }
}