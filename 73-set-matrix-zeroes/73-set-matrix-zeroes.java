class Solution {
    public void setZeroes(int[][] matrix) {
        
        int r = matrix.length; 
        int c = matrix[0].length;
        
        int row[] = new int[r];
        int col[] = new int[c];
        Arrays.fill(row, -1);
        Arrays.fill(col, -1);
        for(int i = 0 ; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                if(matrix[i][j] == 0)
                {
                    col[j] = 0;
                    row[i] = 0;
                }
            }
        }
        
        for(int i = 0; i < r; i++)
        {
            if(row[i] == 0)
            {
                for(int k = 0; k < c; k++)
                    matrix[i][k] = 0;
            }
        }
        
        for(int i = 0; i < c; i++)
        {
            if(col[i] == 0)
            {
                for(int k = 0; k < r; k++)
                    matrix[k][i] = 0;
            }
        }
    }
    
}