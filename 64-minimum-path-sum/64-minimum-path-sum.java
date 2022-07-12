class Solution {
    public int minPathSum(int[][] grid) {
        int[][] table = new int[grid.length][grid[0].length];
        
        for(int i = 0; i < table.length; i++) {
            Arrays.fill(table[i], -1);
        }
        
        return minSum(grid,table,0,0);
    }
    
    public int minSum(int[][] grid, int[][] table, int r, int c) {
        
        if(r == grid.length-1 && c == grid[r].length-1) {
            table[r][c] = grid[r][c];
            return grid[r][c];
        }
        
        if(table[r][c]!=-1) {
            return table[r][c];
        }
        
        int rSum = Integer.MAX_VALUE;
        int cSum = Integer.MAX_VALUE;
        
        
        if(r<grid.length-1)
            rSum = minSum(grid, table, r+1, c);
        
        if(c<grid[r].length-1) {
            cSum = minSum(grid,table,r,c+1);
        }
        
        int sum = Math.min(rSum, cSum) + grid[r][c];
        
        table[r][c] = sum;
        
        return sum;
    }
}
