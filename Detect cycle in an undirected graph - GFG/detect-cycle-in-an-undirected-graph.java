// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends

class Pair{
    int n;
    int parent;
    Pair(int n, int parent)
    {
        this.n = n;
        this.parent = parent;
    }
}
class Solution {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < V; i++)
        {
            if(vis[i] == false)
            {
                vis[i] = true;
                q.add(new Pair(i, -1));
                while(q.size() != 0)
                {
                    Pair curr = q.remove();
                    for(int num : adj.get(curr.n))
                    {
                        if(vis[num] == false)
                        {
                            vis[num] = true;
                            q.add(new Pair(num, curr.n));
                        }
                        else if(num != curr.parent)
                            return true;
                    }
                }
            }
        }
        return false;
    }
}