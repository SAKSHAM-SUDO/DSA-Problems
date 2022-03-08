class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == '#')
            {
                if(!st.isEmpty())
                    st.pop();
            }
            else
                st.push(ch);
        }
        String s1 = "";
        while(!st.isEmpty())
        {
            s1 = st.pop() + s1;
        }
        
        for(int i = 0; i < t.length(); i++)
        {
            char ch = t.charAt(i);
            if(ch == '#')
            {
                if(!st.isEmpty())
                    st.pop();
            }
            else
                st.push(ch);
        }
        String s2 = "";
        while(!st.isEmpty())
        {
            s2 = st.pop() + s2;
        }
        if(s1.equals(s2))
        return true;
        else
            return false;
    }
}