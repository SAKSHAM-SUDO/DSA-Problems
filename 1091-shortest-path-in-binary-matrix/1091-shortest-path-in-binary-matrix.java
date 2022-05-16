class Point{
    int r;
    int c;
    int path;
    
    Point(int r, int c, int path)
    {
        this.r = r;
        this.c = c;
        this.path = path;
    }
}
class Solution {
    
    int[] dx = {1,-1,0,0, 1,-1,1,-1}; // cols
    int[] dy = {0,0,1,-1, 1,1,-1,-1}; // rows

    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        if(grid[0][0] == 1)
            return -1;
        
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0 , 1));
        grid[0][0] = -1; // marking as visisted;
        
        while(!queue.isEmpty())
        {
            Point p = queue.poll();
            
            if(p.r == row - 1 && p.c == col - 1)
                return p.path;
            
            for(int i = 0; i < 8; i++)
            {
                int x = p.r + dx[i];
                int y = p.c + dy[i];
                if(x >= 0 && y >= 0 && x < row && y < col && grid[x][y] == 0)
                {
                    queue.add(new Point(x, y, p.path + 1));
                    grid[x][y] = -1;
                }
                    
            }
        }
        return -1;
    }
}