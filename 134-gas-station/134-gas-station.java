class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curr = 0;
        int start = 0;
        int sumGas = 0;
        int sumCost = 0;
        
        for(int i =0; i < gas.length; i++)
        {
            sumGas = sumGas + gas[i];
        }
        for(int i =0; i < gas.length; i++)
        {
            sumCost = sumCost + cost[i];
        }
        if(sumGas < sumCost)
            return -1;
        
        for(int i = 0; i < gas.length; i++)
        {
            curr = curr + gas[i] - cost[i];
            if(curr < 0)
            {
                start = i + 1;
                curr = 0;
            }
        }
        return start;
    }
}