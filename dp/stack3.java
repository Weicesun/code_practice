public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int b0 = -prices[0];
        int b1 = b0;
        int s0 = 0, s1 = 0, s2 = 0;
        for (int i = 1; i < prices.length; i++) {
            b0 = Math.max(b1, s2 - prices[i]);
            s0 = Math.max(b1 + prices[i], s1);
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }
        return s0;
    }
public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for (int price : prices) {
            release2 = Math.max(release2, hold2 + price);
            hold2 = Math.max(hold2, release1 - price);
            release1 = Math.max(release1, hold1 + price);
            hold1 = Math.max(hold1, -price);
        }
        return release2;
    }
// v2
public int maxProfit(int[] prices) {  
        return max(prices, 2);  
    }  
      
    public int max(int[] prices, int k) {       // k: k times transactions  
        int len = prices.length;  
        if(len == 0) {  
            return 0;  
        }  
        int[][] local = new int[len][k+1];      // local[i][j]: max profit till i day, j transactions, where there is transaction happening on i day  
        int[][] global = new int[len][k+1];     // global[i][j]: max profit across i days, j transactions  
        for(int i=1; i<len; i++) {  
            int diff = prices[i] - prices[i-1];  
            for(int j=1; j<=k; j++) {  
                local[i][j] = Math.max(global[i-1][j-1]+Math.max(diff,0), local[i-1][j]+diff);  
                global[i][j] = Math.max(global[i-1][j], local[i][j]);  
            }  
        }  
        return global[len-1][k];  
    }  
