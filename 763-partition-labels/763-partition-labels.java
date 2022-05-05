class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        int freq[] = new int[26];
        for(int i =0; i < s.length(); i++)
        {
            freq[s.charAt(i) - 'a'] = i;
        }
        
        int maxLast = 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++)
        {
            count++;
            int last = freq[s.charAt(i) - 'a'];
            if(last > maxLast)
            {
                maxLast = last;
            }
            if(i == maxLast)
            {
                list.add(count);
                count = 0;
            }
        }
        return list;
    }
}