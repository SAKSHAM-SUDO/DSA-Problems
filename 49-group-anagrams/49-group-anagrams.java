class Solution {
    public List<List<String>> groupAnagrams(String[] strs)
    {
        List<List<String>> list = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++)
        {
            String s = strs[i];
            char sorted[] = s.toCharArray();
            
            Arrays.sort(sorted);
            String updated = new String(sorted);
            
            if(!map.containsKey(updated))
            {
                map.put(updated, new ArrayList<>());
            }
            
            map.get(updated).add(s);
        }
        list.addAll(map.values());
        return list;
    }
}