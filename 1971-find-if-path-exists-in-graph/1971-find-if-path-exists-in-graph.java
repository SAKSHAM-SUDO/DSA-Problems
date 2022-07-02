class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination)
            return true;
        
        ArrayList<Integer>[] list = new ArrayList[n];
        for(int i =0 ;i<n;i++){
        list[i] = new ArrayList<>();
        }

        for(int[] edge : edges)
        {
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }
        
        boolean visited[] = new boolean[n];
        boolean ans = check(list, edges, source, destination, visited);
        return ans;
    }
    public boolean check(ArrayList<Integer>[] list, int[][] edges, int source, int destination, boolean visited[])
    {
        if(source == destination)
            return true;
        
        visited[source] = true;
        for(int nbr : list[source])
        {
            if(visited[nbr] == false)
            {
                if(check(list, edges, nbr, destination, visited))
                {
                    return true;
                }
            }
        }
        return false;
    }
}