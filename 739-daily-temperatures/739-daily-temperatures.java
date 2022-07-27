class Solution {
    public int[] dailyTemperatures(int[] temp)
    {
        int ans[] = new int[temp.length];
        int max = 0;
        for(int i = temp.length - 1; i >= 0; i--)
        {
            int currTemp = temp[i];
            if(currTemp >= max)
            {
                max = currTemp;
                continue;
            }
            int days = 1;
            while(currTemp >= temp[days + i])
            {
                days = days + ans[i + days];
            }
            ans[i] = days;
        }
        return ans;
    }
}