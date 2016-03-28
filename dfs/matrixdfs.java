    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[board.length - 1][i] == 'O') {
                dfs(board, board.length - 1, i);
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][board[0].length - 1] == 'O') {
               dfs(board, i, board[0].length - 1);
            }
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void dfs(char[][] board, int i, int j) {
        board[i][j] = '1';
        if (i - 1 > 0 && board[i - 1][j] == 'O') {
            dfs(board, i-1, j);
        }
        if (i + 1 < board.length && board[i + 1][j] == 'O') {
            dfs(board, i+1, j);
        }
        if (j - 1 > 0 && board[i][j - 1] == 'O') {
            dfs(board, i, j - 1);
        }
        if (j + 1 < board[0].length && board[i][j + 1] == 'O') {
            dfs(board, i, j + 1);
        }
    }
//130.
