class Solution {
    public boolean validPalindrome(String s) {
        int counter = 0;
        int last = s.length() - 1;
        
        for(int i = 0; i < s.length() / 2; i++)
        {
            if(s.charAt(i) != s.charAt(last))
            {
                return (checkPalin(s, i , last - 1) || checkPalin(s, i+1, last));
            }
            last--;
        }
        return true;
    }
    private boolean checkPalin(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
}