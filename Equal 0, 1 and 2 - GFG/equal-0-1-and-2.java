// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        int count = 0;
        HashMap<String, Integer> map = new HashMap<>();
        int countz = 0;
        int counto = 0;
        int countt = 0;
        int delzo = countz - counto;
        int delot = counto - countt;
        String key = delzo + "#" + delot;
        map.put(key, 1);
        for(int i = 0; i < str.length(); i++)
        {
            char k = str.charAt(i);
            if(k == '0')
            {
                countz++;
            }
            else if(k == '1')
            {
                counto++;
            }
            else
            {
                countt++;
            }
            delzo = countz - counto;
            delot = counto - countt;
            key = delzo + "#" + delot;
            if(map.containsKey(key))
            {
                count+= map.get(key);
                map.put(key, map.get(key) + 1);
            }
            else
            {
                map.put(key, 1);
            }
        }
        return count;
    }
} 