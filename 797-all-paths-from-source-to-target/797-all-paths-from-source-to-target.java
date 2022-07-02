class Solution {
    ArrayList<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        ArrayList<Integer> path = new ArrayList<>();
        path.add(0);
        calc(graph, 0, path, n);
        return ans;
    }
    public void calc(int[][] graph, int idx, ArrayList<Integer> l, int n)
    {
        if(idx == n - 1)
        {
            ans.add(new ArrayList<>(l));
            return;
        }
        
        for(int i : graph[idx])
        {
            l.add(i);
            calc(graph,i,l, n);
            l.remove(l.size()-1);
        }
        
    }
}