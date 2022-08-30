class Solution {
    public void rotate(int[][] matrix)
    {
        int r = matrix.length;
        int c = matrix[0].length;
        
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                if(j > i)
                {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        
        for(int i = 0; i < r; i++)
        {
            int end = r - 1;
            int start = 0;
            
            while(start < end)
            {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
        
    }
}