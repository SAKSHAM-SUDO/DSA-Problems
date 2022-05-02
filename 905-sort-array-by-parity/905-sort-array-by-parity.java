class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        if(nums.length ==1)
            return nums;
        int i = 0; 
        int j = nums.length - 1;
        
        while(i <= j)
        {
            if((nums[i] & 1) == 1 && (nums[j] & 1) != 1)
            {
                nums[i] = nums[i] ^ nums[j];
                nums[j] = nums[i] ^ nums[j];
                nums[i] = nums[i] ^ nums[j];
                i++;
                j--;
            }
            else if((nums[i] & 1 ) == 1 && (nums[j] & 1) == 1)
            {
                j--;
            }
            else{
                i++;
                // j--;
            }
        }
        return nums;
    }
}