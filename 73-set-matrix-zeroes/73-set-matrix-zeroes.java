class Solution {
    public void setZeroes(int[][] matrix) {
        
        int row = matrix.length - 1; 
        int col = matrix[0].length - 1;
        
        boolean visited[][] = new boolean[matrix.length][matrix[0].length];
        
        for(int i = 0 ; i<=row; i++)
        {
            for(int j = 0; j<=col; j++)
            {
                if(matrix[i][j] == 0 && visited[i][j] == false)
                {
                    
                    for(int k = 0; k<matrix.length; k++)
                     {
                        if(matrix[k][j] != 0)
                        {
                            matrix[k][j] = 0;
                            visited[k][j] = true;
                        }

                    }
                    for(int c = 0; c<matrix[0].length; c++)
                    {
                        if(matrix[i][c] != 0)
                        {
                            matrix[i][c] = 0;
                            visited[i][c] = true;
                        }

                    }
                }
                
            }
        }
        
    }
    
}