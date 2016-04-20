public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robs(nums, 0, nums.length - 2), robs(nums, 1, nums.length - 1));
        
    }
    public int robs(int[] nums, int low, int high) {
        int len = nums.length;
        int[] dp = new int[high - low + 1];
        dp[0] = nums[low];
        dp[1] = Math.max(dp[0], nums[low + 1]);
        for (int i = 2; i < high - low + 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i + low], dp[i - 1]);
        }
        return dp[high - low];
    }
