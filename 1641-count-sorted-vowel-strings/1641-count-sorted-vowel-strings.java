class Solution {
    final char[] arr = {'a', 'e', 'i', 'o', 'u'};
    public int countVowelStrings(int n) {
        int count = 0;
        count = calc(0, n, new StringBuilder());
        return count;
    }
    public int calc(int idx, int n, StringBuilder s)
    {
        if(s.length() == n)
        {
            return 1;
        }
        else if(s.length() > n)
            return 0;
        
        int total = 0;
        for(int i = idx; i < 5; i++)
        {
            s.append(arr[i]);
            total = total + calc(i, n, s);
            s.deleteCharAt(s.length() - 1);
        }
        return total;
    }
}