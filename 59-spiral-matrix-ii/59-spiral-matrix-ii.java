class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int c = 1;
        int left = 0;
        int right = n-1;
        int up = 0;
        int down = n-1;
        while(c <= n * n)
        {
            for(int i = left; i <= right; i++)
            {
                arr[up][i] = c;
                c++;
            }
            for(int i = up + 1; i <= down; i++)
            {
                arr[i][right] = c;
                c++;
            }
            for(int i = right -1; i >= left; i--)
            {
                arr[down][i] = c;
                c++;
            }
            for(int i = down - 1; i >= up + 1; i--)
            {
                arr[i][left] = c;
                c++;
            }
            left++;
            right--;
            up++;
            down--;
        }
        return arr;
    }
}