class Solution {
    public int countVowelStrings(int n) {
        int count = 0;
        count = calc(0, n, 0);
        return count;
    }
    public int calc(int idx, int n, int count)
    {
        if(count == n)
        {
            return 1;
        }
        else if(count > n)
            return 0;
        
        int total = 0;
        for(int i = idx; i < 5; i++)
        {
            total = total + calc(i, n, count + 1);
        }
        return total;
    }
}