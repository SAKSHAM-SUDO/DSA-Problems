class Solution {
    private static final int[][] DIRS = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int shortestBridge(int[][] grid) {
        int res = 0;
        boolean found = false;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid.length; j++)
            {
                if(!found && grid[i][j] == 1)
                {
                    dfs(grid, i, j, visited, q);
                    found = true;
                }
            }
        }
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for(int[] d : DIRS) {
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    
                    if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length ||                                     visited[x][y]) continue;
                    
                    if(grid[x][y] == 1) return res;
                    visited[x][y] = true;
                    q.offer(new int[]{x, y});
                }
            }       
            res++;
        }
        
        return res;
    }
    
    private void dfs(int[][] grid, int i, int j, boolean[][] visited, Queue<int[]> q)
    {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid.length || visited[i][j] ||                           grid[i][j] != 1) return;
        
        visited[i][j] = true;
        q.offer(new int[]{i, j});
        for(int[] d : DIRS)
        {
            dfs(grid, i + d[0], j + d[1], visited, q);
        }
    }
}
