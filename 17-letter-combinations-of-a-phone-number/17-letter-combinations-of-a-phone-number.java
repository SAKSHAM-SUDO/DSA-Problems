class Solution {
    final static HashMap<Character,String> map=new HashMap<>(){{
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        put('7',"pqrs");
        put('8',"tuv");
        put('9',"wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return new ArrayList<>();
        
        ArrayList<String> list = new ArrayList<>();
        backtrack(new StringBuilder(), digits, list, digits.length());
        return list;
    }
    public void backtrack(StringBuilder res, String digits, ArrayList<String> list, int len)
    {
        if(res.length() == len)
        {
            list.add(res.toString());
            return;
        }
        char ch = (digits.charAt(0));
        String word = map.get(ch);
        for(int i = 0; i < word.length(); i++)
        {
            res.append(word.charAt(i));
            backtrack(res, digits.substring(1), list, len);
            res.deleteCharAt(res.length()-1);
        }
    }
}