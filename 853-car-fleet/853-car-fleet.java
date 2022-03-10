class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Double carData[][] = new Double[n][2]; // double because time calculated can be in decimal
        
        for(int i = 0; i < n; i++)
        {
            carData[i][0] = position[i] * 1d; // storing position of each car
            carData[i][1] = (target - position[i] * 1d)/ speed[i]; // storing time taken by each car
        }
        Arrays.sort(carData, (a, b) -> Double.compare(a[0], b[0]));
        
        int nof = 1;
        double tt = carData[n-1][1];
        for(int i = n - 2; i >= 0; i--)
        {
            if(carData[i][1]  > tt)
            {
                nof++;
                tt = carData[i][1];
            }
        }
        return nof;
    }
}