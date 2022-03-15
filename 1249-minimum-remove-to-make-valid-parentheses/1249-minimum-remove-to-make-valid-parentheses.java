class Solution {
    public String minRemoveToMakeValid(String s) {
        int open = 0;
        String ans = "";
        
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch =='(')
            {
                open++;
            }
            else if(ch == ')')
            {
                if(open == 0)
                    continue;
                open--;
            }
            ans = ans + ch;
        }
        
        String reverse = "";
        for(int i = ans.length()- 1; i>= 0; i--)
        {
            char ch = ans.charAt(i);
            if(ch == '(' && open-- > 0) continue;
            
            reverse = ch + reverse;
        }
        return reverse;
    }
}