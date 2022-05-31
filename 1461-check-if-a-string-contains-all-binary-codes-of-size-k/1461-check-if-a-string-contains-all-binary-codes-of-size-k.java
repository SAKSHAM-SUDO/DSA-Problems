class Solution {
    public boolean hasAllCodes(String s, int k) {
        int count = (int)Math.pow(2, k);
        HashSet<String> list = new HashSet<>();
        
        for(int i = 0; i <= s.length() - k; i++)
        {
            String sub = s.substring(i, i + k);
            if(!list.contains(sub))
            {
                count--;
                list.add(sub);
            }
        }
        if(count == 0)
            return true;
        else 
            return false;
    }
}