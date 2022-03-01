class Solution {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length;
        int ans[] = new int[n];
        Stack<Integer> st = new Stack<>();
        int hottest = 0;
        
        for(int i  = n-1; i >= 0; i--)
        {
            if(t[i] >= hottest)
            {
                hottest = t[i];
                continue;
            }
            int days = 1;
            while(t[i + days] <= t[i])
            {
                days = days +  ans[i + days];
            }
            ans[i] = days;
        }
        
        return ans;
    }
}