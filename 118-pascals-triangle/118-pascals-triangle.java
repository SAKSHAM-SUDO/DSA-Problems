class Solution
{
    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        
        for(int i = 0; i < numRows; i++)
        {
            List<Integer> curr = new ArrayList<>();
            for(int j = 0; j <= i; j++)
            {
                
                if(j == 0 || j == i)
                    curr.add(1);
                
                else
                {
                    curr.add(prev.get(j) + prev.get(j - 1));
                }
            }
            prev = curr;
            list.add(curr);
        }
        return list;
    }
}