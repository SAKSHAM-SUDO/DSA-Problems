class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        String currString = "";
        int currNo = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch))
            {
                currNo = currNo * 10 + (ch -'0');
            }
            else if(ch == '[')
            {
                st.push(currString);
                st.push(String.valueOf(currNo));
                currNo = 0;
                currString = "";
            }
            else if(ch >= 'a' && ch <= 'z')
            {
                currString = currString + ch;
            }
            else{
                int prevNo = Integer.parseInt(st.pop());
                String prevString = st.pop();
                String temp = currString;
                while(prevNo != 1)
                {
                    currString = currString + temp;
                    prevNo--;
                }
                currString = prevString + currString;
            }
        }
        return currString;
        
    }
}   
