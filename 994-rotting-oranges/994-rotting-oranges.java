class Solution {
    class Pair
    {
        int x;
        int y;
        Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int fresh = 0;
        Queue<Pair> q = new LinkedList<>();
        int dir[][] = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                if(grid[i][j] == 1)
                {
                    fresh++;
                    grid[i][j] = -1;
                }
                else if(grid[i][j] == 2)
                    q.add(new Pair(i, j));
            }
        }
        if(fresh == 0)
            return 0;
        int count = -1;
        while(!q.isEmpty())
        {
            int size = q.size();
            count++;
            while(size --> 0)
            {
                Pair curr = q.poll();
                int x = curr.x;
                int y = curr.y;

                for(int i = 0; i < 4; i++)
                {
                    int xx = x + dir[i][0];
                    int yy = y + dir[i][1];

                    if(xx >= 0 && yy >= 0 && xx < r && yy < c && grid[xx][yy] < 0)
                    {
                        fresh--;
                        grid[xx][yy] = 2;
                        q.add(new Pair(xx, yy));
                    }
                }
            }
        }
        if(fresh == 0)
            return count;
        else 
            return -1;
    }
}