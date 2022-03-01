class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n == 1)
            return heights[0];
        
        int nse[] = new int[n];
        int pse[] = new int[n];
        int area[] = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(n - 1);
        nse[n-1] = n;
        for(int i = n-2; i >= 0; i--)
        {
            while(!st.isEmpty() && heights[i] <= heights[st.peek()])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                nse[i] = n;
            }
            else{
                nse[i] = st.peek();
            }
            st.push(i);
        }
        st = new Stack<>();
        st.push(0);
        pse[0] = -1;
        for(int i = 1; i < n; i++)
        {
            while(!st.isEmpty() && heights[i] <= heights[st.peek()])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                pse[i] = -1;
            }
            else{
                pse[i] = st.peek();
            }
            st.push(i);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i  < n; i++)
        {
            area[i] = heights[i] * (nse[i] - pse[i] - 1);
            if(area[i] > max)
                max = area[i];
        }
        return max;
        
    }
}