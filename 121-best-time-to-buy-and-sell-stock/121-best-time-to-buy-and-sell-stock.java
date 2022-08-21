class Solution
{
    public int maxProfit(int[] prices)
    {
        int maxProfit = 0;
        int minPrice = prices[0];
        
        for(int i = 1; i < prices.length; i++)
        {
            maxProfit = (int)Math.max(maxProfit, prices[i] - minPrice);
            
            if(prices[i] < minPrice)
                minPrice = prices[i];
        }
        return maxProfit;
    }
}