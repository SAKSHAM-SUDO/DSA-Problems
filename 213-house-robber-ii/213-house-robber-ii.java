class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int arr1[] = new int[nums.length - 1];
        int arr2[] = new int[nums.length - 1];
        int k = 0, c = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(i != 0)
            arr1[k++] = nums[i];
            if(i != nums.length - 1)
                arr2[c++] = nums[i];
        }
        int first = count(arr1) ;
        int second = count(arr2);
        return Math.max(first, second);
    }
        public int count(int[] nums) {
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
}