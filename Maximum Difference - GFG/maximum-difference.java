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
    int findMaxDiff(int a[], int n)
    {
        Stack<Integer>s=new Stack<>();
        int left[]=new int[n];
        int right[]=new int[n];
        for(int i=0;i<n;i++)
        {
            while(!s.isEmpty() && s.peek()>=a[i])
            {
                s.pop();
            }
            int res=s.isEmpty()?0:s.peek();
            left[i]=res;
            s.push(a[i]);
        }
        s.clear();
        for(int i=n-1;i>=0;i--)
        {
            while(!s.isEmpty() && s.peek()>=a[i])
            {
                s.pop();
            }
            int res=s.isEmpty()?0:s.peek();
            right[i]=res;
            s.push(a[i]);
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            max = Math.max(max , Math.abs(left[i] - right[i]));
        }
        return max;

    }
}