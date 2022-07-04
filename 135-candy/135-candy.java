class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int left[] = new int[n];
        int right[] = new int[n];
        Arrays.fill(right, 1);
        Arrays.fill(left, 1);
        for(int i = 1; i < n; i++)
        {
            if(ratings[i-1] < ratings[i])
                left[i] = left[i-1] + 1;
        }
        for(int j = n - 2; j >= 0; j--)
        {
            if(ratings[j] > ratings[j + 1])
                right[j] = right[j+1] + 1;
        }
        int sum = 0;
        for(int i =0; i < n; i++)
        {
            sum += Math.max(right[i], left[i]);
        }
        return sum;
    }
}