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
    public int[][] updateMatrix(int[][] mat) {
        
        int dirs[][] = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Pair> q = new LinkedList<>();
        
        for(int i = 0; i < mat.length; i++)
        {
            for(int j = 0; j < mat[0].length; j++)
            {
                if(mat[i][j] == 1)
                    mat[i][j] = -1;
                else
                    q.add(new Pair(i,j));
            }
        }
        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            
            for(int i = 0; i < dirs.length; i++)
            {
                int xx = x + dirs[i][0];
                int yy = y + dirs[i][1];
                
                if( xx >= 0 && yy >= 0 && xx < mat.length && yy < mat[0].length && mat[xx][yy] < 0)
                {
                    mat[xx][yy] = 1 + mat[x][y];
                    q.add(new Pair(xx, yy));
                }
            }
        }
        
        return mat;
    }
}