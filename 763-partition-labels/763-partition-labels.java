class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int lastMax = 0;
        for(int i =0; i < s.length(); i++)
        {
            map.put(s.charAt(i), i);
        }
        int count = 0;
        int maxLast = 0;
        for(int j = 0; j < s.length(); j++)
        {
            count++;
            int last = map.get(s.charAt(j));
            if(last > maxLast)
            {
                maxLast = last;
            }
            if(j == maxLast)
            {
                list.add(count);
                count = 0;
            }
        }
        return list;
    }
}