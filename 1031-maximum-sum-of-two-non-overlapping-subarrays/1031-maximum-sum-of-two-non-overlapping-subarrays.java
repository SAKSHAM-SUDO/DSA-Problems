class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int x, int y)
    {
        int firstAhead=solve(nums,x,y);
        int secondAhead=solve(nums,y,x);
        return Math.max(firstAhead,secondAhead);
    }
    public int solve(int[]nums,int x,int y)
    {
        int n=nums.length,sum=0;
        int []dp1=new int[n];
        int []dp2=new int[n];
        for(int i=0;i<n;i++){
            if(i<x){
                sum+=nums[i];
                dp1[i]=sum;
            }
            else{
                sum+=nums[i]-nums[i-x];
                dp1[i]=Math.max(sum,dp1[i-1]);
            }
        }
        sum=0;
        for(int i=n-1;i>=0;i--){
            if(i+y>=n){
                sum+=nums[i];
                dp2[i]=sum;
            }
            else{
                sum+=nums[i]-nums[i+y];
                dp2[i]=Math.max(sum,dp2[i+1]);
            }
        }
        int ans=0;
        for(int i=x-1;i<n-y;i++){
            ans=Math.max(ans,dp1[i]+dp2[i+1]);
        }
        return ans;
        
    }
}
