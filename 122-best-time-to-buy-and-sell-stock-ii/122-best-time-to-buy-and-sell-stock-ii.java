class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        for(int i = 0; i < prices.length; i++)
        {
            if(prices[i] < buy)
            {
                buy = prices[i];
            }
            else{
                profit = profit + prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }
}