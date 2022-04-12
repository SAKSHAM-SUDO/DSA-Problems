class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int c = count(board, i, j);
                if(board[i][j] == 1) {
                    if(c < 2) { 
                        board[i][j] = -1; // -1 represents live cell becomes dead
                    }
                    if(c == 2 || c == 3) {
                        board[i][j] = 1;
                    }
                    if(c > 3) {
                        board[i][j] = -1;  // -1 represents live cell becomes dead
                    }
                } else {
                    if(c == 3) {
                        board[i][j] = -2;  // -2 represents died cell becomes live
                    }
                }
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == -1) {
                    board[i][j] = 0; // Restore the value for next stage
                }
                if(board[i][j] == -2) {
                    board[i][j] = 1; // Restore the value for next stage
                }
            }
        }
    }
    // Count live neighbours
    public int count(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        if(i-1 >= 0 && j-1 >= 0) {
            if(board[i-1][j-1] == 1 || board[i-1][j-1] == -1) count++;
        }
        if(i-1 >= 0 && j >= 0) {
            if(board[i-1][j] == 1 || board[i-1][j] == -1) count++;
        }
        if(i-1 >= 0 && j+1 < n) {
            if(board[i-1][j+1] == 1 || board[i-1][j+1] == -1) count++;
        }
        
        if(i >= 0 && j-1 >= 0) {
            if(board[i][j-1] == 1 || board[i][j-1] == -1) count++;
        }
        if(i >= 0 && j+1 < n) {
            if(board[i][j+1] == 1 || board[i][j+1] == -1) count++;
        }
        
        if(i+1 < m && j-1 >= 0) {
            if(board[i+1][j-1] == 1 || board[i+1][j-1] == -1) count++;
        }
        if(i+1 < m && j >= 0) {
            if(board[i+1][j] == 1 || board[i+1][j] == -1) count++;
        }
        if(i+1 < m && j+1 < n) {
            if(board[i+1][j+1] == 1 || board[i+1][j+1] == -1) count++;
        }
        return count;
    }
}
