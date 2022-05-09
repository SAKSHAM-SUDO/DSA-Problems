class Solution {
    String arr[] = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return new  ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        ans = calc("", digits, digits.length());
        return ans;
    }
    public ArrayList<String> calc(String res, String digits, int len)
    {
        if(res.length() == len)
        {
            ArrayList<String> l = new ArrayList<>();
            l.add(res);
            return l;
        }
        int index = (digits.charAt(0) - '0') - 2;
        String word = arr[index];
        ArrayList<String> list = new ArrayList<>();
        for(int j = 0; j < word.length(); j++)
        {
            list.addAll(calc(res + word.charAt(j), digits.substring(1), len));
        }
        return list;
    }
}