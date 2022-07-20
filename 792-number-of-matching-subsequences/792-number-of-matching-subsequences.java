class Solution {
    public int numMatchingSubseq(String s, String[] words)
    {
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;
        
        for(String st : words)
            map.put(st, map.getOrDefault(st, 0) + 1);
        
        char ch[] = s.toCharArray();
        
        for(String st : map.keySet())
        {
            char curr[] = st.toCharArray();
            int i = 0;
            int j = 0;
            
            while(i < ch.length && j < curr.length)
            {
                if(ch[i] == curr[j])
                {
                    i++;
                    j++;
                }
                else
                    i++;
            }
            if(j == curr.length)
                count += map.get(st);
        }
        
        return count;
    }
}