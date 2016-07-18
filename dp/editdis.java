public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int k = 0; k < m + 1; k++) {
            dp[k][0] = k;
        }
        for (int k = 0; k < n + 1; k++) {
            dp[0][k] = k;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    continue;
                }
                //if (j > i) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = Math.min(dp[i - 1][j] - 1, dp[i - 1][j - 1]);
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                    }
                //}
                
            }
        }
        return dp[m][n];
    }
}
