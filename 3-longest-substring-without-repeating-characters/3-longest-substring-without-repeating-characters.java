class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int length = 0;
        // map.put();
        int i = 0;
        int j = 0;
        
        while(j < s.length())
        {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            if(map.size() == j - i + 1)
            {
                length = Math.max(length, j - i + 1);
            }
            else if(map.size() < j - i + 1)
            {
                while(map.size() < j - i + 1)
                {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if(map.get(s.charAt(i)) == 0)
                        map.remove(s.charAt(i));
                    i++;
                }
            }
            j++;
        }
        return length;
    }
}