class Solution {
    public int totalHammingDistance(int[] nums) {
        // int count = 0;
        // for(int i = 0; i < nums.length; i++)
        // {
        //     for(int j = i + 1; j < nums.length; j++)
        //     {
        //         count =  count + hamming(nums[i], nums[j]);
        //     }
        // }
        // return count;
        
        
        
        
        
        int count  = 0; 
        for(int i = 0; i < 32; i++)
        {
            int onn = 0;
            for(int j = 0; j < nums.length; j++)
            {
                if((nums[j] & (1 << i)) != 0)
                    onn++;
                // onn+=(nums[j]>>i)&1;
            }
            int off = nums.length - onn;
            count = count + (onn * off);
        }
        return count;    
    }
    
//     public int hamming(int x, int y)
//     {
//             int distance = 0;

//             while (x != 0 || y !=0) {
//                 if ((((x & 1) == 0) && (y & 1) == 1) || (((x & 1) == 1) && (y & 1) == 0)) {
//                     distance++;
//                 }

//                 x >>= 1;
//                 y >>= 1;
//             }

//         return distance;
//     }
}