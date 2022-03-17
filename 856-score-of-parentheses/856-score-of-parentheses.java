class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int count = 0;
        st.push(0);

        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                st.push(0);
            }
            else{
                int last = st.pop();
                int sLast = st.pop();
                st.push(sLast + Math.max(2* last, 1));
            }
        }
        return st.pop();
    }
}