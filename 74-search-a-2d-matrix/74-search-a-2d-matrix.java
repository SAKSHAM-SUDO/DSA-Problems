class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(target < matrix[0][0] || target> matrix[matrix.length -1][matrix[0].length -1 ])
            return false;
        
        int row = searchRow(matrix, target);
        if(row == -1) return true;
        return searchCol(matrix, target, row);
    }
    
    private int searchRow(int[][] matrix, int target){
		int mid;
        int left = 0, right = matrix.length - 1;
		while(left <= right){
			mid = (left + right) / 2;
			if(matrix[mid][0] == target) return -1;
			else if(matrix[mid][0] > target) right = mid  - 1;
			else if(matrix[mid][0] < target) left = mid + 1;
		}

		return right;
	}
    
    public static boolean searchCol(int matrix[][], int target, int row)
    {
        int l = 0, h = matrix[0].length - 1;
        
        while(l<=h)
        {
            int mid = (l+h)/2;
            
            if(matrix[row][mid] == target)
                return true;
            
            else if(matrix[row][mid] > target)
            {
                h = mid -1;
            }
            else
                l = mid + 1;
        }
        return false;
    }
}
