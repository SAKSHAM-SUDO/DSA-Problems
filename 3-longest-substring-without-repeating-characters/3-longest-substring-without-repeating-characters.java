class Solution {
    public int lengthOfLongestSubstring(String s) {
        String copy = "";
        int max = 0;
        int curr = 0;
        int j = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(copy.indexOf(ch) == -1)
            {
                curr++;
                copy = copy + ch;
            }
            else
            {
                if(curr > max)
                    max = curr;
                int idx = copy.indexOf(ch);
                copy = copy.substring(idx + 1) + ch;
                curr = copy.length();
            }
        }
        return curr > max ? curr : max;
    }
}