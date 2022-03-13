class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(st.isEmpty() || ch =='(' || ch == '{' || ch == '[')
            {
                st.push(ch);
            }
            else{
                if(ch == ')' && st.peek() != '(')
                {
                    return false;
                }
                else if(ch == '}' && st.peek() != '{')
                {
                    return false;
                }
                else if(ch == ']' && st.peek() != '[')
                {
                    return false;
                }
                else{
                    st.pop();
                }
            }
        }
        return st.isEmpty() ? true : false;
    }
}