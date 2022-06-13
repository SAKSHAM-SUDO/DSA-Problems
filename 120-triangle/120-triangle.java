class Solution {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][] = new int[triangle.size()][triangle.size()];
        for(int row[] : dp)
        Arrays.fill(row, -1);
        return helper(triangle, 0, 0, dp);
    }
    
    private int helper(List<List<Integer>> triangle, int rowIdx, int colIdx, int dp[][]) {
        if(rowIdx >= triangle.size() || colIdx == triangle.get(rowIdx).size()) return 0;

        else if(dp[rowIdx][colIdx] != -1)
            return dp[rowIdx][colIdx];
        else
        {
            int adjacent = triangle.get(rowIdx).get(colIdx) + helper(triangle, rowIdx + 1, colIdx,                              dp);
            int adjacentPlusOne = triangle.get(rowIdx).get(colIdx) + helper(triangle, rowIdx + 1,                                       colIdx + 1, dp);
            dp[rowIdx][colIdx] = Math.min(adjacent, adjacentPlusOne);
        }
        
        return dp[rowIdx][colIdx];
    }
}
