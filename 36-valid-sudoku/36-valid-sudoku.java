class Solution {
    public boolean isValidSudoku(char[][] board)
    {
        HashSet set = new HashSet();
        
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                if(board[i][j] == '.')
                    continue;
                
                if(!set.add("row" + i + board[i][j]) || !set.add("col" + j + board[i][j]))
                    return false;
                
                int boxNo = (i / 3) * 3 + j / 3;
                if(!set.add("box" + boxNo + board[i][j]))
                    return false;
            }
        }
        return true;
    }
}