class Solution {
    public int longestStrChain(String[] words)
    {
        int dp[] = new int[words.length];
        Arrays.fill(dp, 1);
        int max = 1;
        Arrays.sort(words, (a,b)-> a.length()-b.length());

        for(int i = 1; i < words.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(compare(words[i], words[j]) && dp[i] < dp[j] + 1)
                {
                    dp[i] = dp[j] + 1;
                }
            }
            if(dp[i] > max)
                max = dp[i];
        }
        return max;
    }
    public boolean compare(String word1, String word2)
    {
        if(word1.length() != word2.length() + 1)
            return false;
        
        int i = 0;
        int j = 0;
        while(i < word1.length())
        {
            if(j < word2.length() && word1.charAt(i) == word2.charAt(j))
            {
                i++;
                j++;
            }
            else
                i++;
        }
        if(i == word1.length() && j == word2.length())
            return true;
        
        return  false;

    }
}
