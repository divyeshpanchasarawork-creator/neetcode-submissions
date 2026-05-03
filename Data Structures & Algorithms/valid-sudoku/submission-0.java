class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' 
                        && (checkRow(board[i][j], i, j, board)
                        || checkCol(board[i][j], i, j, board)
                        || checkGrid(board[i][j], i, j, board))) return false;
            }
        }
        return true;
    }

    private boolean checkRow(char ch, int i, int j, char[][] b) {
        for (int k = 0; k < 9; k++) {
            if (k != j && b[i][k] == ch) return true;
        }
        return false;
    }

    private boolean checkCol(char ch, int i, int j, char[][] b) {
        for (int k = 0; k < 9; k++) {
            if (k != i && b[k][j] == ch) return true;
        }
        return false;
    }

    private boolean checkGrid(char ch, int i, int j, char[][]b) {
        int boxRowStart = (i / 3) * 3;
        int boxColStart = (j / 3) * 3;
        for (int l = boxRowStart; l < boxRowStart + 3; l++) {
            for (int m = boxColStart; m < boxColStart + 3; m++) {
                if ((l != i || m != j) && ch == b[l][m]) return true;
            }
        }
        return false;
    } 
}