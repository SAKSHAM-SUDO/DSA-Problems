class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int n : nums)
        {
            map.put(n, true);
        }
        System.out.println(map);
 
        for(int keys : map.keySet())
        {
            if(map.containsKey(keys - 1))
            {
                map.put(keys, false);
            }
        }
        System.out.print(map);
        int longest = 0;
        
        for(int keys : map.keySet())
        {
            int curr = 0;
            if(map.get(keys))
            {
                // int curr = 1;
                int num = keys;
                while(map.containsKey(num))
                {
                    curr++;
                    num++;
                }
            }
            longest = Math.max(longest, curr);
        }
        return longest;
    }
}