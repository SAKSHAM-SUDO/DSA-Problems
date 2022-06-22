class Solution {
    public int maxDistToClosest(int[] seats) {
        int res = 0;
        int val = 0;
        for(int i = 0; i < seats.length; i++)
        {
            if(seats[i] == 1)
            {
                val = 0;
            }
            else
            {
                val++;
                res = Math.max(res, (val+1) / 2);
            }
        }
        
        for(int i = 0; i < seats.length; i++)
        {
            if(seats[i] == 1)
            {
                res = Math.max(res, i);
                break;
            }
        }
        for(int i = seats.length - 1;i >= 0; i--)
        {
            if(seats[i] == 1)
            {
                    res = Math.max(res, seats.length - 1 - i);
                    break;
            }   
        }
        return res;
    }
}