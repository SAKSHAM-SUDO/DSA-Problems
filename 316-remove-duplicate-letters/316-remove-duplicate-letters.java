class Solution {
    public String removeDuplicateLetters(String s) {
        int freq[] = new int[26];
        Stack<Character> st = new Stack<>();
        boolean[] present = new boolean[26];
        st.push(s.charAt(0));
        freq[s.charAt(0) - 'a']--;
        present[s.charAt(0) - 'a'] = true;
        for(int i = 0; i < s.length(); i++)
        {
            freq[s.charAt(i) - 'a']++;
        }
        
        for(int i = 1; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            freq[ch - 'a']--;
            if(!present[ch - 'a'])
            {
               while(!st.isEmpty() && ch < st.peek() && freq[st.peek()- 'a'] != 0)
               {
                   present[st.peek()-'a'] = false;
                   st.pop();
               }
                st.push(ch);
                present[ch - 'a'] = true;
            }
        }
        String ans = "";
        while(!st.isEmpty())
        {
            ans = st.pop() + ans;
        }
        return ans;
    }
}