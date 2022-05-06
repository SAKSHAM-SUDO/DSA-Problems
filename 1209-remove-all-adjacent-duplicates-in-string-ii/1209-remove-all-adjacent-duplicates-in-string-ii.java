class Solution {
    
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            if(!st.isEmpty() && s.charAt(i) == st.peek().ch)
            {
                Pair p = st.peek();
                int j = p.c + 1;
                st.pop();
                st.push(new Pair(p.ch, j));
            }
            else{
                st.push(new Pair(s.charAt(i), 1));
            }
            
            if(st.peek().c == k)
            {
                st.pop();
            }
        }
        
        String ans = "";
        while(!st.isEmpty())
        {
            Pair p = st.pop();
            int c = p.c;
            while(c-- != 0)
                ans = p.ch + ans;
        }
        return ans;
    }
    class Pair
    {
        char ch;
        int c;
        Pair(char ch, int c)
        {
            this.ch = ch;
            this.c = c;
        }
    }
}