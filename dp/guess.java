public class Solution {
    public int getMoneyAmount(int n) {
        
        int[][] dp = new int[n + 1][n + 1];
        int start = 1;
        int end = n;
        
       
        for (int dis = 1; dis <= end; dis++) {
            for (int i = start; i + dis <= end; i++) {
                int j = i + dis;
                int amount = Integer.MAX_VALUE;
                int index = i;
                if (dp[i][j] != 0) {
                    continue;
                }
                while (index <= j) {
                    amount = Math.min(amount, index + Math.max(index - 1 >= i ? dp[i][index - 1] : 0,j >= index + 1 ? dp[index + 1][j] : 0));
                    index++;
                }
                dp[i][j] = amount;
            }
        }
        return dp[start][end];
    }
}
