class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int left[] = new int[n];
        Arrays.fill(left, 1);
        for(int i = 1; i < n; i++)
        {
            if(ratings[i-1] < ratings[i])
                left[i] = left[i-1] + 1;
        }
        int sum = left[n - 1];
        for(int j = n - 2; j >= 0; j--)
        {
            if(ratings[j] > ratings[j + 1])
                left[j] = Math.max(left[j], left[j + 1] + 1);
            sum += left[j];
        }
        return sum;
    }
}