// { Driver Code Starts
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();
			Solution ob = new Solution();
			System.out.println(ob.findMaxDiff(a,n));
		t--;
		}
	}
}// } Driver Code Ends



class Solution
{
    int findMaxDiff(int A[], int n)
    {
	int[] left = new int[n];
      int[] right = new int[n];
      left[0] = 0;
      right[n-1] = 0;
      Stack<Integer> st = new Stack<>();
      st.push(A[n-1]);
      
      for(int i = n-2; i >= 0; i--)
      {
        while(!st.isEmpty() && st.peek() >= A[i])
        {
            st.pop();
        }
        if(st.isEmpty())
        {
            right[i] = 0;   
        }
        else
            right[i] = st.peek();
            
        st.push(A[i]);
      }
      st = new Stack<>();
      Stack<Integer> st1 = new Stack<>();
      st1.push(A[0]);
      for(int i = 1; i < n; i++)
      {
          while(!st1.isEmpty() && A[i] <= st1.peek())
          {
              st1.pop();
          }
          if(st1.isEmpty())
          {
              left[i] = 0;
          }
          else{
              left[i] = st1.peek();
          }
          st1.push(A[i]);
      }
      

      int max = Integer.MIN_VALUE;
      for(int i = 0; i < n; i++)
      {
          max = Math.max(max, Math.abs(left[i] - right[i]));
      }
      return max;
    }
}