class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) {
            if (visited[i][j] == 0) {
                if (dfs(grid, i, j, visited, -1, -1)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] g, int r, int c, int[][] visited, int prevR, int prevC) {
        visited[r][c] = 1;
        
        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];
            
            if (nr < 0 || nr >= g.length || nc < 0 || nc >= g[0].length || g[nr][nc] != g[r][c]) continue;
            if (nr == prevR && nc == prevC) continue;
            if (visited[nr][nc] == 1) return true;
            else if (dfs(g, nr, nc, visited, r, c)) return true;
        }
        return false;
    }
}
