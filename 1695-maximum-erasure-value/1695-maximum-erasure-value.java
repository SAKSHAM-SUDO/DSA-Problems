class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        boolean[] present=new boolean[10001];
        int left=0,sum=0,max=0;
        for(int i=0;i<nums.length;i++)
        {
            if(!present[nums[i]])
            {
                sum+=nums[i];
                present[nums[i]]=true;
            }
            else
            {
                max=Math.max(max,sum);
                while(nums[left]!=nums[i])
                {
                    present[nums[left]]=false;
                    sum-=nums[left];
                    left++;
                }
                left++;
            }
        }
        return Math.max(max,sum);
    }
}