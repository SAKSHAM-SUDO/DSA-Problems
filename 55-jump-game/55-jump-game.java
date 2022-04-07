class Solution {
    public boolean canJump(int[] nums)
    {
        int len = nums.length;
        boolean[] visited = new boolean[len];
        return check(0, nums, len, visited);
    }
    public boolean check(int idx, int nums[], int len, boolean visited[])
    {
        if(idx >= len)
        {
            return false;
        }
        if(idx == len-1)
        {
            return true;
        }
        if(visited[idx])
        {
            return false;
        }
        visited[idx] = true;
        int maxSteps = nums[idx];
        if(maxSteps == 0)
        {
            return false;
        }
            
        for(int i = 1; i <= maxSteps; i++)
        {
            if(check(idx + i, nums, len, visited))
                return true;
            
        }
        return false;
    }
}