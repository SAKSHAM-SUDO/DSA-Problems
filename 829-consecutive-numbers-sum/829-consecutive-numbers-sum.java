class Solution {
    public int consecutiveNumbersSum(int n) {
        int count = 1;
        
        for(int k = 2; 2*n > k*(k-1); k++)
        {
            int numerator = n - k * (k - 1) / 2;
            if(numerator % k == 0)
                count++;
        }
        return count;
    }
}