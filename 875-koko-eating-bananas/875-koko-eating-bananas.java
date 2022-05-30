class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 0;
        int right = 0;
        for(int pile : piles)
        {
            right = Math.max(right, pile);
        }
        while(left < right)
        {
            int minBanana = left + (right - left)/2;
            
            if(possible(piles, h, minBanana))
            {
                right = minBanana;
            }
            else
            {
                left = minBanana + 1;
            }
        }
        return right;
    }
    public boolean possible(int piles[], int hours, int minSpeed)
    {
        int currHours = 0;
        for(int i = 0; i < piles.length; i++)
        {
            currHours += Math.ceil(piles[i] * 1.0 / minSpeed);
        }
        return currHours <= hours;
    }
}