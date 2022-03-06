class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> st = new Stack<Character>();
        int count = 0;
        boolean duplicate = false;
        for(int i = 0; i < s.length(); i++)
        {
            if(!st.isEmpty() && st.peek() == s.charAt(i))
            {
                count++;
            }
            else 
                count = 1;
            st.push(s.charAt(i));
            if(count == k)
            {
                while(count != 0 )
                {
                    st.pop();
                    count--;
                }
                duplicate = true;
                count = 1;
            }
        }
        String ss = "";
        while(!st.isEmpty())
        {
            ss = st.pop() + ss;
        }
        if(duplicate)
        {
            return removeDuplicates(ss, k);
        }
        else
            return ss;
    }
}