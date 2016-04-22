public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n ; i++) {
            int j = 1;
            while(j * j <= i) {
                dp[i] = Math.min(dp[i - j*j] + 1, dp[i]);
                j++;
            }
        }
        return dp[n];
    }
