class Solution {
    public String removeDuplicates(String s, int k) {
        
        Stack<Character> st = new Stack<>();
        int count = 0;
        boolean duplicate = false;
        
        for(int i = 0; i < s.length(); i++)
        {
            if(!st.isEmpty() && s.charAt(i) == st.peek())
            {
                count++;
            }
            else{
                count = 1;
            }
            st.push(s.charAt(i));
            
            if(count == k)
            {
                while(count != 0)
                {
                    st.pop();
                    count--;
                }
                count = 1;
                duplicate = true;
            }
        }
        String ans = "";
        while(!st.isEmpty())
        {
            ans = st.pop() + ans;
        }
        if(duplicate)
        {
             return removeDuplicates(ans, k);
        }
        return ans;
    }
}