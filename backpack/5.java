public int backPackV(int[] A, int m) {
        // Write your code here
           int[][] dp = new int[A.length + 1][m + 1];
           dp[0][0] = 1;
       for (int i = 1; i < dp.length; i++) {
           for (int j = 0; j < dp[0].length; j++) {
               dp[i][j] = dp[i - 1][j];
               if (j >= A[i - 1]) {
                   dp[i][j] = dp[i - 1][j] + dp[i - 1][j - A[i - 1]];
               }
           }
       }
       return dp[dp.length - 1][dp[0].length - 1];
    }
