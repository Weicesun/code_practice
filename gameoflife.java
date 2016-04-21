public class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    nextStateLive(board, i, j);
                }
                if (board[i][j] == 0) {
                    nextStateDead(board, i, j);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] > 1) {
                    board[i][j] = 0;
                }
                if (board[i][j] < 0) {
                    board[i][j] = 1;
                }
            }
        }
    }
    public void nextStateLive(int[][] board, int i, int j) {
        int countLive = 0;
        if (i > 0 && board[i - 1][j] >= 1) {
            countLive++;
        } 
        if (j > 0 && board[i][j - 1] >= 1 ){
            countLive++;
        }
        if (i > 0 && j > 0 && board[i - 1][j - 1] >= 1) {
            countLive++;
        }
        if (i > 0 && j < board[0].length - 1 && board[i - 1][j + 1] >= 1) {
            countLive++;
        }
        if (j < board[0].length - 1 && board[i][j + 1] >= 1) {
            countLive++;
        }
        if (i < board.length - 1 && board[i + 1][j] >= 1) {
            countLive++;
        } 
        if (i < board.length - 1 && j < board[0].length - 1 && board[i + 1][j + 1] >= 1) {
            countLive++;
        }
        if (i < board.length - 1 && j > 0 && board[i + 1][j - 1] >= 1) {
            countLive++;
        }
        int countDead = 8 - countLive;
        if (countLive > 3 || countLive < 2) {
            board[i][j]++;
        }
    }
    public void nextStateDead(int[][] board, int i, int j) {
        int countLive = 0;
        if (i > 0 && board[i - 1][j] >= 1) {
            countLive++;
        } 
        if (j > 0 && board[i][j - 1] >= 1 ){
            countLive++;
        }
        if (i > 0 && j > 0 && board[i - 1][j - 1] >= 1) {
            countLive++;
        }
        if (i > 0 && j < board[0].length - 1 && board[i - 1][j + 1] >= 1) {
            countLive++;
        }
        if (j < board[0].length - 1 && board[i][j + 1] >= 1) {
            countLive++;
        }
        if (i < board.length - 1 && board[i + 1][j] >= 1) {
            countLive++;
        } 
        if (i < board.length - 1 && j < board[0].length - 1 && board[i + 1][j + 1] >= 1) {
            countLive++;
        }
        if (i < board.length - 1 && j > 0 && board[i + 1][j - 1] >= 1) {
            countLive++;
        }
        int countDead = 8 - countLive;
        if (countLive == 3) {
            board[i][j]--;
        }
    }
}
