class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int r = matrix.length;
        int c = matrix[0].length;
        int count = 0;
        int sr = 0;
        int er = r - 1;
        int sc = 0;
        int ec = c - 1;
        while(count < r * c)
        {
            for(int i = sc; i <= ec && count < (r * c); i++)
            {
                count++;
                list.add(matrix[sr][i]);
            }
            sr++;
            for(int i = sr; i <= er && count < (r * c); i++)
            {
                count++;
                list.add(matrix[i][ec]);
            }
            ec--;
            for(int i = ec; i >= sc && count < (r * c); i--)
            {
                count++;
                list.add(matrix[er][i]);
            }
            er--;
            for(int i = er; i >= sr && count < (r * c); i--)
            {
                count++;
                list.add(matrix[i][sc]);
            }
            sc++;
        }
        return list;
    }
}