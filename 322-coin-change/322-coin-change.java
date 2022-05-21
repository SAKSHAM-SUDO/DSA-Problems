class Solution {
    public int coinChange(int[] coins, int amount) {
        int t[][] = new int[coins.length + 1][amount + 1];
        for(int v[] : t){
            Arrays.fill(v, -1);
        }

        int minCoins = subsetmin(coins, amount, coins.length, t);
        return minCoins == Integer.MAX_VALUE - 1 ? -1 : minCoins;
    }
    public int subsetmin(int coins[], int sum, int n, int t[][]){
        if(n == 0 && sum != 0) return Integer.MAX_VALUE - 1;
        if(sum == 0) return 0;
        if(t[n][sum] != -1) return t[n][sum];
        
        if(coins[n - 1] <= sum){
            t[n][sum] =  Math.min(subsetmin(coins, sum - coins[n - 1], n, t) + 1, subsetmin(coins, sum, n - 1, t));
        }
        else{
            t[n][sum] =  subsetmin(coins, sum, n - 1, t);
        }
        
        return t[n][sum];
    }
}
