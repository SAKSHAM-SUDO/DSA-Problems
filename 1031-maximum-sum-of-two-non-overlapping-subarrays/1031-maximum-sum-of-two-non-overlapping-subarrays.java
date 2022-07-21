class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen)
    {
        int firstAhead = findMaxSum(nums, firstLen, secondLen);
        int secondAhead = findMaxSum(nums, secondLen, firstLen);
        
        return Math.max(firstAhead, secondAhead);
    }
    public int findMaxSum(int[] nums, int firstLen, int secondLen)
    {
        
        int size = nums.length;
        int first[] = new int[size];
        int second[] = new int[size];
        int sum = 0;
        
        for(int i = 0; i < size; i++)
        {
            if(i < firstLen)
            {
                sum += nums[i];
                first[i] = sum;
            }
            else
            {
                sum = sum + nums[i] - nums[i - firstLen];
                first[i] = Math.max(first[i - 1], sum);
            }
        }
        sum = 0;
        for(int i = size - 1; i >= 0; i--)
        {
            if(i >= size - secondLen)
            {
                sum += nums[i];
                second[i] = sum;
            }
            else
            {
                sum = sum + nums[i] - nums[i + secondLen];
                second[i] = Math.max(sum, second[i + 1]);
            }
        }
        int ans = 0;
        for(int i = firstLen - 1; i < size - secondLen; i++)
        {
            ans = Math.max(ans, first[i] + second[i + 1]);
        }
        return ans;
    }
}