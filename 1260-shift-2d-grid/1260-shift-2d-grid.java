class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> list = new ArrayList<>();
        
        int m = grid.length;
        int n = grid[0].length;
        int tLength = m * n;
        k = k % tLength;
        for(int i = 0; i < m; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < tLength; i++)
        {
            int index = (tLength - k + i) % tLength;
            list.get(i/n).add(grid[index/n][index%n]);
        }
        return list;
    }
}