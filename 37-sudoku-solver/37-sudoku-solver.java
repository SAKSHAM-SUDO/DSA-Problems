class Solution {
    public  void solveSudoku(char[][] board) 
    {
        solve(board, 0, 0);
    }
    public boolean solve(char[][] board, int row, int col)
    {
        if(row >= 9)
        {
            return true;
        }
        else if(col >= 9)
        {
            return solve(board, row + 1, 0);
        }
        
        else if(board[row][col] == '.')
        {
            for(char i = '1'; i <= '9'; i++)
            {
                if(isSafe(board, row, col, i))
                {
                board[row][col] = i;
                boolean solved = solve(board, row, col+1);
                if(solved) return true;
                else board[row][col] = '.';
                }
            }
        }
        else{
           return solve(board, row, col + 1);
        }
        
        return false;
    }

    boolean isSafe(char[][] board,int r, int i, int j){
        for(int k=0;k<9;k++){
            if(board[r][k]==j)
                return false;
            if(board[k][i]==j)
                return false;
        }
        int sqrt = (int)Math.sqrt(board.length);
        int rowstart = r-r%sqrt;
        int colstart = i-i%sqrt;
        for(int a=rowstart;a<rowstart+sqrt;a++){
            for(int b =colstart;b<colstart+sqrt;b++){
                if(board[a][b]==j)
                    return false;
            } 
        }
        return true;
    }
}