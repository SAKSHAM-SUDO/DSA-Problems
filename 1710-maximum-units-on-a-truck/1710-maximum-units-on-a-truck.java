class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        int maxCap = 0;
        int left = truckSize;
        for(int i = 0; i < boxTypes.length; i++)
        {
            if(left <= 0)
                break;
            
            if(boxTypes[i][0] <= left)
            {
                maxCap += boxTypes[i][0] * boxTypes[i][1];
                left -= boxTypes[i][0];
            }
            else
            {
                maxCap += (left) * boxTypes[i][1];
                left = 0;
            }
                
        }
        return maxCap;
    }
}