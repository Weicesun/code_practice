public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] array = new int[len + 2];
        array[0] = 1;
        array[len + 1] = 1;
        for (int i = 0; i < len; i++) {
            array[i + 1] = nums[i];
        }
        int[][] dp = new int[len + 2][len + 2];
        return helper(dp, array, 0, len + 1);
    }
    public int helper(int[][] dp, int[] array, int left, int right) {
        if (left + 1 == right) {
            return 0;
        }
        if (dp[left][right] != 0) {
            return dp[left][right];
        }
        int max = -1;
        for (int i = left + 1; i < right; i++) {
            max = Math.max(max, array[i] * array[left]* array[right] + helper(dp, array, left, i) 
            + helper(dp, array, i, right));
        }
        dp[left][right] = max;
        return max;
    }
