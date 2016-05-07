        private int diagnal1 = 0;
        private int antidiagnal1 = 0;
        private int[] row1;
        private int[] col1;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        row1 = new int[n];
        col1 = new int[n];
        
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
            int toadd = player == 1 ? 1 : -1;
            row1[row] += toadd;
            col1[col] += toadd;
            if (row == col) {
                diagnal1 += toadd;
            }
            int n = row1.length;
            if (row + col == n - 1) {
                antidiagnal1 += toadd;
            }
           
                if (Math.abs(row1[row]) == n || Math.abs(col1[col]) == n || Math.abs(diagnal1) == n || Math.abs(antidiagnal1) == n) {
                    return player;
                }
            
         
        return 0;
