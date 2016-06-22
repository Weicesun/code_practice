public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = findnei(board, i, j);
                if ((board[i][j] & 1) == 1 && live > 1 && live < 4) {
                    board[i][j] = 3;
                }
                if ((board[i][j] & 1) == 0 && live == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = (board[i][j] >> 1);
            }
        }
    }
    public int findnei(int[][] board, int i, int j) {
        int live = 0;
        for (int p = Math.max(0, i - 1); p <= Math.min(i + 1, board.length - 1); p++) {
            for (int q = Math.max(0, j - 1); q <= Math.min(j + 1, board[0].length -1); q++) {
                if (p == i && q == j) {
                    continue;
                }
                live += (board[p][q] & 1);
            }
        }
        return live;
    }
