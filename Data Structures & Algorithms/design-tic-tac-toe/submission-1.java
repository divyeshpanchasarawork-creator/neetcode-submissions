class TicTacToe {
    private final int[][] board;
    private final int size;
    public TicTacToe(int n) {
        board = new int[n][n];
        size = n;
    }

    public int move(int row, int col, int player) {
        board[row][col] = player;
        if (checkWin(row, col))
            return player;
        return 0;
    }

    private boolean checkWin(int row, int col) {
        return checkRow(row) || checkCol(col) || checkDiagonal();
    }

    private boolean checkRow(int row) {
        for (int i = 1; i < size; i++) {
            if (board[row][i - 1] != board[row][i])
                return false;
        }
        return true;
    }

    private boolean checkCol(int col) {
        for (int i = 1; i < size; i++) {
            if (board[i - 1][col] != board[i][col])
                return false;
        }

        return true;
    }

    private boolean checkDiagonal() {
        boolean mainDiagWin = (board[0][0] != 0);
        boolean antiDiagWin = (board[0][size - 1] != 0);

        for (int i = 1; i < size; i++) {
            if (board[i][i] != board[i - 1][i - 1]) {
                mainDiagWin = false;
            }

            if (board[i][size - 1 - i] != board[i - 1][size - i]) {
                antiDiagWin = false;
            }

            if (!mainDiagWin && !antiDiagWin)
                return false;
        }

        return mainDiagWin || antiDiagWin;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
