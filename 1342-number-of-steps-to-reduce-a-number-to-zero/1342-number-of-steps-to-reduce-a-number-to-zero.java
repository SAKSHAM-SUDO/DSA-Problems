class Solution {
    public int numberOfSteps(int n) {
        int lastBit = n % 2;
        int count = 0;
        while(n != 0)
        {
            if((n & 1) == 0)
            {
                n = n >> 1;
            }
            else
            {
                n = n - 1;
            }
            count++;
        }
        return count;
    }
}