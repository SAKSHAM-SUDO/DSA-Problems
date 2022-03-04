class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st1 = new Stack<>();
        st1.push(-1);
        int ans = 0;
        int f = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == '(')
            {
                st1.push(i);
            }
            else{
                st1.pop();
                
                if(st1.isEmpty())
                {
                    st1.push(i);
                }
                else{
                    ans = Math.max(ans, i - st1.peek());
                }
            }
        }
        return ans;
        
    }
}