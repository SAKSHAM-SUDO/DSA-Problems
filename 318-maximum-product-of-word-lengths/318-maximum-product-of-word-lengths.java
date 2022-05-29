class Solution {
    public int maxProduct(String[] words) {
        int bitState[] = new int[words.length];
        
        for(int i = 0; i < words.length; i++)
        {
            bitState[i] = getBitMask(words[i]);
        }
        int maxProduct = 0;
        for(int i = 0; i < words.length; i++)
        {
            for(int j = i + 1; j < words.length; j++)
            {
                if((bitState[i] & bitState[j]) == 0)
                {
                    if(words[i].length() * words[j].length() > maxProduct)
                    {
                        maxProduct = words[i].length() * words[j].length();
                    }
                }
            }
        }
        return maxProduct;
    }
    public int getBitMask(String st)
    {
        int mask = 0;
        for(char ch : st.toCharArray())
        {
            mask |= 1 << (ch - 'a');
        }
        return mask;
    }
}