class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int j = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char e = s.charAt(i);
            if(map.containsKey(e))
            {
                while(map.containsKey(e))
                {
                    map.remove(s.charAt(j));
                    j++;
                }
            }
            map.put(e, 1);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}