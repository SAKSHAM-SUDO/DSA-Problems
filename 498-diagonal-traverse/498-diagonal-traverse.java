class Solution {
    public int[] findDiagonalOrder(int[][] mat)
    {
        int r = mat.length;
        int c = mat[0].length;
        int ans[] = new int[r * c];
        int i = 0;
        int j = 0;
        int a = 0;
        boolean up = true;
        
        while(a < r * c)
        {
            if(up)
            {
                while(i >= 0 && j < c)
                {
                    ans[a++] = mat[i][j];
                    i--;
                    j++;
                }
                i++;
                if(j == c)
                {
                    j--;
                    i++;
                }
            }
            else
            {
                while(j >= 0 && i < r)
                {
                    ans[a++] = mat[i][j];
                    i++;
                    j--;
                }
                j++;
                if(i == r)
                {
                    i--;
                    j++;
                }
            }
            up = !up;
        }
        return ans;
    }
}