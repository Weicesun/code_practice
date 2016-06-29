public int maxProfit(int k, int[] prices) {
        
        if (prices == null || prices.length == 0 || k <= 0) {
            return 0;
        }
        int hold = Integer.MIN_VALUE;
        int release = 0;
        int prerelease = 0;
        for (int price : prices) {
            for (int j = k - 1; j >= 1; j--) {
                release[j] = Math.max(release[j], hold[j] + price);
                hold[j] = Math.max(hold[j], release[j - 1]-price);
                
            }
            release[0] = Math.max(release[0], hold[0] + price);
            hold[0] = Math.max(hold[0], -price);
            
        }
        return release[k - 1];
    }
