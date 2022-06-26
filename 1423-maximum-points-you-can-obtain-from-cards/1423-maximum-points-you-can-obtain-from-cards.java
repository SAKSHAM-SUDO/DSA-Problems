class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for(int i : cardPoints)
        {
            sum+= i;
        }
        if(k == cardPoints.length)
        {
            return sum;
        }
        int windowSum = 0;
        int maxSum = 0;
        for(int i = 0; i < k; i++)
        {
            windowSum += cardPoints[i];
        }
        maxSum = windowSum;
        int start = k - 1;
        int end = cardPoints.length - 1;
        while(start >= 0)
        {
            windowSum-= cardPoints[start--];
            windowSum += cardPoints[end--];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
}