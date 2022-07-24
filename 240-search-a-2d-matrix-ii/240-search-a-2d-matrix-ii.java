class Solution
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        int r = matrix.length;
        int c = matrix[0].length;
        
        int sr = 0;
        int ec = c - 1;
        
        while(sr < r && ec >= 0)
        {
            if(matrix[sr][ec] == target)
                return true;
            
            else if(matrix[sr][ec] > target)
                ec--;
            
            else
                sr++;
        }  
        return false;
    }
}