class Solution {
    public void solveSudoku(char[][] board) {
        if(solve(board)) {
            return;
        }
    }

    public boolean solve(char[][] board) {
        int r = -1;
        int c = -1;
        boolean emptyLeft = false; 

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    r = i;
                    c = j;
                    emptyLeft = true;
                    break;
                }
            }
            if(emptyLeft) {
                break;
            }
        }
        if(!emptyLeft) {
            return true;
        }

        for (int i = 1; i <= board.length; i++) {
            if (isSafe(board, r, c, (char)('0' + i))) {
                board[r][c] = (char)('0' + i);
                if(solve(board)) {
                    return true;
                }
                else {
                    board[r][c] = '.';
                }
            }
        }
        return false;
    }

    public boolean isSafe(char[][] board, int r, int c, char num) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][c] == num) {
                return false;
            }
        }

        for (int i = 0; i < board[r].length; i++) {
            if (board[r][i] == num) {
                return false;
            }
        }

        int startR = r - r % 3;
        int startC = c - c % 3;
        for (int i = startR; i < startR+3; i++) {
            for (int j = startC; j < startC+3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}