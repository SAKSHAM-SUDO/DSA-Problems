class Solution {
    public int rob(int[] nums) {
        int prev = nums[0];
        int prev2 = 0;
        
        for(int i = 1; i < nums.length; i++)
        {
            int take = nums[i];
            if(i > 1)
                take+= prev2;
            int notTake = prev;
            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
//     public int count(int nums[], int idx)
//     {
//         if(idx == 0)
//             return nums[0];
//         if(idx < 0)
//             return 0;
        
//         int take = nums[idx] + count(nums, idx - 2);
//         int notTake = count(nums, idx - 1);
//         return Math.max(take, notTake);
//     }
}