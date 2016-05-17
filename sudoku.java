public boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            int[] temp = new int[9];
            
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int index = board[i][j] - '1';
                if (temp[index] == 1) {
                    return false;
                } else {
                    temp[index] = 1;
                }
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            int[] temp = new int[9];
            
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                int index = board[j][i] - '1';
                if (temp[index] == 1) {
                    return false;
                } else {
                    temp[index] = 1;
                }
            }
        }
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[0].length; j += 3 ) {
                int tempi = i;
                int tempj = j;
                int[] result = new int[9];
                for (tempi = i; tempi < i + 3; tempi++) {
                    for (tempj = j; tempj < j + 3; tempj++) {
                        if (board[tempi][tempj] == '.') {
                            continue;
                        }
                        int index = board[tempi][tempj] - '1';
                        if (result[index] == 0) {
                            result[index] = 1;
                        } else if (result[index] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
