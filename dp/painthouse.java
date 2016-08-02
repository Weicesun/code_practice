public class Solution {
    public int minCostII(int[][] cost) {
        if (cost == null || cost.length == 0 || cost[0].length == 0) {
            return 0;
        }
        int m = cost.length;
        int n = cost[0].length;
        int[][] dp = new int[m][n];
        PriorityQueue<Integer> pre = new PriorityQueue<Integer>();
        
        for (int i = 0; i < m; i++) {
            PriorityQueue<Integer> cur = new PriorityQueue<Integer>();
            
            for (int j = 0; j < n; j++) {
                dp[i][j] = cost[i][j];
                if (pre.size() != 0) {
                    pre.remove(new Integer(dp[i - 1][j]));
                    //System.out.println(pre.peek());
                    dp[i][j] += pre.peek();
                    pre.offer(dp[i - 1][j]);
                }
                cur.offer(dp[i][j]);
            }
            pre = cur;
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            
            res = Math.min(res, dp[m - 1][j]);
        }
        return res;
    }
}
