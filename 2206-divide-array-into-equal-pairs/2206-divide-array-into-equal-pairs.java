class Solution {
    // public boolean divideArray(int[] nums) {
    //     int res = 0;
    //     int n = nums.length;
    //     for(int i = 0; i < nums.length; i++)
    //     {
    //         res = res ^ nums[i];
    //     }
    //     if(res == 0)
    //         return true;
    //     else
    //         return false;
    // }
      public boolean divideArray(int[] nums) {
          Arrays.sort(nums);
          for(int i=0;i<nums.length;i+=2) {
                int xor = nums[i]^nums[i+1];
                if(xor!=0)return false;
          }
          return true;
    }

}