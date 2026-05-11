class Solution {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == w[0] && dfs(i, j, board, 0, w)) return true; 
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, char[][] board, int k, char[] word) {
        if (k == word.length) return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;

        if (board[i][j] == '#' || board[i][j] != word[k]) return false;

        char temp = board[i][j];
        board[i][j] = '#';

        boolean top = dfs(i - 1, j, board, k + 1, word);
        boolean bottom = dfs(i + 1, j, board, k + 1, word);
        boolean left = dfs(i, j - 1, board, k + 1, word);
        boolean right = dfs(i, j + 1, board, k + 1, word);

        board[i][j] = temp;

        return top || bottom || left || right;
    }
}
