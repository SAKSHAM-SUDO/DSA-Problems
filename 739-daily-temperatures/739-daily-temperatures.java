class Solution {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length;
        int ans[] = new int[n];
        Stack<Integer> st = new Stack<>();
        
        ans[n - 1] = 0;
        st.push(n-1);
        
        // for(int i = n-2; i >= 0; i--)
        // {
        //     if(!st.isEmpty() && t[i] < t[st.peek()])
        //     {
        //         ans[i] = st.peek() - i;
        //         st.push(i);
        //     }
        //     else{
        //         while(!st.isEmpty() && t[i] >= t[st.peek()])
        //         {
        //             st.pop();
        //         }
        //         if(st.isEmpty())
        //         {
        //             st.push(i);
        //             ans[i] = 0;
        //         }
        //         else{
        //             ans[i] = st.peek() - i;
        //             st.push(i);    
        //         }
        //     }
        // }
        
        for(int i = n-2; i >= 0; i--)
        {
            while(!st.isEmpty() && t[i] >= t[st.peek()])
            {
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = 0;
            }
            else{
                ans[i] = st.peek() - i;
            }
            st.push(i);
        }
        return ans;
    }
}