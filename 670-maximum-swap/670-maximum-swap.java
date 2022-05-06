class Solution {
    public int maximumSwap(int s) {
        String num = s + "";
        int n = num.length();
        int rightMax[] = new int[n];
        int nums[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            nums[i] = (num.charAt(i) - '0');
        }
        
        rightMax[n - 1] = n - 1;
        
        for(int i = n - 2; i >= 0; i--)
        {
            if(nums[i] > nums[rightMax[i + 1]]) 
            {
                rightMax[i] = i;
            }
            else
                rightMax[i] = rightMax[i + 1];
        }
        
        
        
        
        
        
        for(int i = 0; i < n; i++)
        {
            System.out.print(rightMax[i] + ", ");
        }
        
        for(int i = 0; i < n; i++)
        {
            if(nums[i] < nums[rightMax[i]])
            {
                nums[i] = nums[i] ^ nums[rightMax[i]];
                nums[rightMax[i]] = nums[i] ^ nums[rightMax[i]];
                nums[i] = nums[i] ^ nums[rightMax[i]];
                break;
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < n; i++)
        {
            ans.append(nums[i]);
        }
        return Integer.parseInt(ans.toString());
    }
}