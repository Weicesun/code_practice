int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        if (dungeon[m - 1][ n -1] < 0) {
            dp[m - 1][n - 1] = -dungeon[m - 1][n - 1] + 1;
        } else {
            dp[m - 1][n - 1] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            int temp = dp[i + 1][n - 1] - dungeon[i][n - 1];
            dp[i][n - 1] = temp <= 0 ? 1 : temp;
        }
        for (int i = n - 2; i >= 0; i--) {
            int temp = dp[m - 1][i + 1] - dungeon[m - 1][i];
            dp[m - 1][i] = temp <= 0 ? 1 : temp;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int temp = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = temp <= 0 ? 1 : temp;
            }
        }
        return dp[0][0];
