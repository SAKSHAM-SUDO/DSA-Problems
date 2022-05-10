class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        calc(1, 0, n, k, list, new ArrayList<>());
        return list;
    }
    public void calc(int idx, int sum, int target, int k,
                                    List<List<Integer>> list, List<Integer> sub)
    {
        if(sub.size() == k)
        {
            if(sum == target)
            {
                list.add(new ArrayList<>(sub));
            }
            return;
        }
        for(int i = idx; i <= 9; i++)
        {
            sub.add(i);
            calc(i + 1, sum + i, target, k, list, sub);
            sub.remove(sub.size() - 1);
        }
    }
}