public int kSum(int A[], int k, int target) {
        // write your code here
        int[][][] dp = new int[A.length + 1][k + 1][target + 1];
        for (int i = 0; i < A.length + 1; i++) {
            dp[i][0][0] = 1;
        }
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= k; j++) {
                for (int t = 1; t <= target; t++) {
                    dp[i][j][t] = dp[i - 1][j][t];
                    if (t >= A[i - 1])
                    dp[i][j][t] += dp[i - 1][j - 1][t - A[i - 1]];
                }
            }
        }
        return dp[A.length][k][target];
    }
