class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        Arrays.fill(color, -1);
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++)
        {
            if(color[i] == -1)     // not colored
            {
                color[i] = 1;
                q.add(i);
                while(!q.isEmpty())
                {
                    int curr = q.remove();
                    for(int num : graph[curr])
                    {
                        if(color[num] == -1)
                        {
                            q.add(num);
                            color[num] = 1 - color[curr];
                        }
                        else if(color[num] == color[curr])
                            return false;
                    }
                }
            }
        }
        return true;
    }
}