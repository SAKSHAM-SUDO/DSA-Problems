class Solution {
    public int findCircleNum(int[][] connected) {
        int n = connected.length;
        int count= 0;
        for(int i = 0; i < n; i++)
        {
            if(connected[i][i] == 1)
            {
                count(connected, i);
                count++;
            }
        }
        return count;
    }
    public void count(int connected[][], int curr)
    {
        for(int j = 0; j < connected.length; j++)
        {
            if(connected[j][j] == 1 && connected[curr][j] == 1)
            {
                connected[j][j] = 0;
                count(connected, j);
            }   
        }
    }
}