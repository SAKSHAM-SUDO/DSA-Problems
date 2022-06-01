// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        int index = -1;
        int count = 0;
        
        for(int i = 0; i < n; i++)
        {
            int c = getCount(arr, i, m);
            // System.out.println(c);
            if(c > count)
            {
                count = c;
                index = i;
            }
        }
        return index;
    }
    public int getCount(int arr[][], int i, int m)
    {
        int start = 0;
        int end = m - 1;
        int count = 0;
        
        if(arr[i][end] == 0)
        return 0;
        
        else if(arr[i][start] == 1)
        return m;
        
        
        while(start <= end)
        {
            int mid = start + (end  -start) / 2;
            if(arr[i][mid] == 1)
            {
                if( mid - 1 >= 0 && arr[i][mid - 1] != 1)
                {
                    count = m - mid;
                    return count;
                }
                else
                {
                    end = mid - 1;
                }
            }
            else
            {
                start = mid + 1;
            }
        }
        return count;
    }
}