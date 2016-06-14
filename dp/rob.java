int[] profit = new int[nums.length];
        profit[0] = nums[0];
        if (nums.length <= 3) {
            return Math.max(nums[0], Math.max(nums[1], nums[2]));
        }
        profit[1] = nums[0];
        for (int i = 2; i < nums.length - 1; i++) {
            profit[i] = Math.max(profit[i - 2] + nums[i], profit[i - 1]);
        }
        int temp1 = profit[nums.length - 2];
        for (int i = )
