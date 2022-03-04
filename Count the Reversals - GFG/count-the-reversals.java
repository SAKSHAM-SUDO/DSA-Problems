// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
    		System.out.println (new Sol().countRev (s));
        }
        
    }
}
// Contributed By: Pranay Bansal
// } Driver Code Ends


//User function Template for Java

class Sol
{
    int countRev (String s)
    {
        if(s.length() % 2  == 1)
            return -1;
            
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            
            if(ch == '{')
            {
                st.push(ch);
            }
            else{
                if(!st.isEmpty() && st.peek() == '{')
                {
                    st.pop();
                }
                else{
                    st.push('}');
                }
            }
        }
        
        // int length = st.size();
        // int open = 0;
        // while(!st.isEmpty())
        // {
        //     if(st.peek() == '{')
        //     {
        //         open++;
        //     }
        //     st.pop();
        // }
        // return (int)(Math.ceil((length - open) / 2) + Math.ceil(open));
        
        int red_len = st.size();
     
        // count opening brackets at the end of
        // stack
        int n = 0;
        while (!st.empty() && st.peek() == '{')
        {
            st.pop();
            n++;
        }
     
        // return ceil(m/2) + ceil(n/2) which is
        // actually equal to (m+n)/2 + n%2 when
        // m+n is even.
        return (red_len/2 + n%2);
    }
}