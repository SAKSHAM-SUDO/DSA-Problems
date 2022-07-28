class Solution {
    public int largestRectangleArea(int[] heights)
    {
        int size = heights.length;
        int nser[] = new int[size];
        Stack<Integer> st = new Stack<>();
        nser[size - 1] = size;
        st.push(size - 1);
        
        for(int i = size - 2; i >= 0; i--)
        {
            int c = 0;
            while(!st.isEmpty() && heights[i] <= heights[st.peek()])
            {
                c++;
                st.pop();
            }
            if(st.isEmpty())
                nser[i] = size;
            else
                nser[i] = st.peek();
            
            st.push(i);
        }
                
        int nsel[] = new int[size];
        st = new Stack<>();
        nsel[0] = -1;
        st.push(0);
        
        for(int i = 1; i < size; i++)
        {
            while(!st.isEmpty() && heights[i] <= heights[st.peek()])
            {
                st.pop();
            }
            if(st.isEmpty())
                nsel[i] = -1;
            else
                nsel[i] = st.peek();
            
            st.push(i);
        }
        
        int max = 0;
        int curr = 0;
        for(int i = 0; i < size; i++)
        {
            curr = (nser[i] - nsel[i] - 1) * heights[i];
            if(curr > max)
                max = curr;
        }
        return max;
    }
}