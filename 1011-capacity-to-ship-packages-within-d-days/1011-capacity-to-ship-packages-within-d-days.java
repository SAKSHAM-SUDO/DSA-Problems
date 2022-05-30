class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        
        for(int element : weights)
        {
            right += element;
        }
        
        while(left < right)
        {
            int minWeight = left + (right - left)/2;
            
            if(possible(weights, days, minWeight))
            {
                right = minWeight;
            }
            else
            {
                left = minWeight + 1;
            }
        }
        return right;
    }
    public boolean possible(int weights[], int days, int minWeight)
    {
        int actualDays = 1;
        int currWeight = 0;
        for(int i = 0; i < weights.length; i++)
        {
            if(weights[i] > minWeight)
                return false;
            if(currWeight + weights[i] <= minWeight)
            {
                currWeight += weights[i];
            }
            else
            {
                currWeight = weights[i];
                actualDays++;
            }
        }
        if(actualDays > days)
            return false;
        else
            return true;
    }
}