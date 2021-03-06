// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean dfsVis[] = new boolean[V];
        
        for(int i = 0; i < V; i++)
        {
            if(!vis[i])
            {
                if(dfs(adj, i, vis, dfsVis))
                    return true;
            }
        }
        return false;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int idx, boolean[] vis,boolean[] dfsVis)
    {
        
        vis[idx] = true;
        dfsVis[idx] = true;
        
        for(int n : adj.get(idx))
        {
            if(!vis[n])
            {
                if(dfs(adj, n, vis, dfsVis))
                    return true;
            }
            else if(dfsVis[n])
                return true;
        }
        dfsVis[idx] = false;
        return false;
    }
}