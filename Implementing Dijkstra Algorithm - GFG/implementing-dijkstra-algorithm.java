// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Pair implements Comparable<Pair> 
{
    int dis;
    int node;
    Pair(int dis, int node)
    {
        this.dis = dis;
        this.node = node;
    }
    @Override
    public int compareTo(Pair p)
    {
        if(this.dis <= p.dis)
            return -1;
        else
            return 1;
    }
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(0, S));
        int distance[] = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[S] = 0;
        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            int val = curr.node;
            int dis = curr.dis;
            // ArrayList<Integer> list = ;
            for(ArrayList<Integer>  num : adj.get(val))
            {
                if(distance[num.get(0)] > dis + num.get(1))
                {
                    distance[num.get(0)] = dis + num.get(1);
                    q.add(new Pair(dis + num.get(1), num.get(0)));
                }
            }
        }
        return distance;
    }
}

