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
        
        int count=0;
        char c1=0,c2=0;
        while(!st.isEmpty()) {
            c1 = st.pop();
            c2 = st.pop();
            if (c1 == c2) {
                count++;
            } else {
                count += 2;
            }
        }
        return count;       

    }
}