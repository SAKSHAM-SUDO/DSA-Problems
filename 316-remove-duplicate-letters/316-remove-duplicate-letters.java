class Solution {
    public String removeDuplicateLetters(String s) {
        int freq[] = new int[26];
        
        for(int i = 0; i < s.length(); i++)
        {
            freq[s.charAt(i) - 'a']++;
        }
        boolean[] exist = new boolean[26];
        Arrays.fill(exist, false);
        Stack<Character> st = new Stack<>();
        
        for(int i =0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            freq[ch - 'a']--;
            if(!exist[ch - 'a'])
            {
                while(!st.isEmpty() && st.peek() > ch && freq[st.peek() - 'a'] != 0)
                {
                    char popped = st.pop();
                    exist[popped - 'a'] = false;
                }
                st.push(ch);
                exist[ch - 'a']  = true;
            }
        }
        String ans=  "";
        
        while(!st.isEmpty())
        {
            ans = st.pop() + ans;
        }
        return ans;
    }
}