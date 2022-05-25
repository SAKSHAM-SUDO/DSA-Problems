
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
    Arrays.sort(envelopes,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
    int lis[] = new int[envelopes.length];
    lis[0]=1;
    int dp[]=new int[envelopes.length];
    dp[0]=envelopes[0][1];
    int max=1;
    for(int i=1;i<envelopes.length;i++)
    {     
        if(envelopes[i][1] > dp[max-1])
        {
            dp[max++]=envelopes[i][1];
    
        }
        else
        {
            int index = binarySearch(dp,0,max,envelopes[i][1]);
            dp[index] = envelopes[i][1];
            if(index==max)
                max++;
        }
        
    }
    return max;
    
}

int binarySearch(int dp[],int start,int end,int target)
{
    while(start<end)
    {
        int mid = start + (end-start)/2;
        if(dp[mid]==target)
            return mid;
        else if(dp[mid]>target)
            end=mid;
        else
            start=mid+1;
        
    }
    return start;
}
}