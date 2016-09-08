public boolean firstWillWin(int[] values) {
        // write your code here
        int len = values.length;
        int[] dp = new int[len + 1];
        boolean[] flag = new boolean[len + 1];
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum < 2 * search(len, values, flag, dp);
    }
    public int search(int len, int[] values, boolean[] flag, int[] dp) {
        if (flag[len]) {
            return dp[len];
        }
        flag[len] = true;
        if (len == 0) {
            dp[len] = 0;
        } else if (len == 1) {
            dp[len] = values[values.length - 1];
        } else if (len == 2) {
            dp[len] = values[values.length - 1] + values[values.length - 2];
        } else if (len == 3) {
            dp[len] = values[values.length - 3] + values[values.length - 2];
        } else {
            dp[len] = Math.max(Math.min(search(len - 2, values, flag, dp), search(len - 3, values, flag, dp)) + values[values.length - len], Math.min(search(len - 3, values, flag, dp), search(len - 4, values, flag, dp)) + values[values.length - len] + values[values.length - len + 1]);
        }
        return dp[len];
    }
}
