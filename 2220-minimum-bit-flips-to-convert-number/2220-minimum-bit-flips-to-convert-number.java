class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        int mask = start ^ goal;
        
        while(mask != 0)
        {
            count = count + (mask & 1);
            mask = mask >> 1;
        }
        return count;
    }
}