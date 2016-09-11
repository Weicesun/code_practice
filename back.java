public int backPack(int m, int[] A) {
        // write your code here
        boolean[][] dp = new boolean[A.length + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = false;
            }
        }
        dp[0][0] = true;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i + 1][j] = dp[i][j];
                if (j >= A[i] && dp[i][j - A[i]]) {
                    dp[i + 1][j] = true;
                }
            }
        }
        for (int i = m; i >= 0; i--) {
            if (dp[A.length][i]) {
                return i;
            }
        }
        return 0;
    }
