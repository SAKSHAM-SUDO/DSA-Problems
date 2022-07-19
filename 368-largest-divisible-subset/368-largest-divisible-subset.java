class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums)
    {
        int dp[] = new int [nums.length];
        int hash[] = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        int lastIndex = 0;
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++)
        {
            hash[i] = i;
            for(int j = 0; j < i; j++)
            {
                if(nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1)
                {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            if(dp[i] > max)
            {
                max = dp[i];
                lastIndex = i;
            }
        }
        
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(nums[lastIndex]);
        while (hash[lastIndex] != lastIndex)
        {
            lastIndex = hash[lastIndex];
            temp.add(nums[lastIndex]);
        }

        Collections.reverse(temp);
        return temp;
    }
}