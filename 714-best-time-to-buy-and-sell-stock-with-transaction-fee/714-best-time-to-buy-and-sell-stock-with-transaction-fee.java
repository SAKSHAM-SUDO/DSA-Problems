class Solution {
    public int maxProfit(int[] prices, int fee) {
        int bsp = -prices[0];
        int ssp = 0;
        for(int i = 1; i < prices.length; i++)
        {
            if(ssp - prices[i] > bsp)
            {
                bsp = ssp - prices[i];
            }
            if(prices[i] + bsp - fee > ssp)
            {
                ssp = prices[i] + bsp - fee;
            }
        }
        return ssp;
    }
}