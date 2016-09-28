public int findMin(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[start] > nums[end]){
                if (nums[mid] > nums[start]) {
                    start = mid;
                } else {
                    end = mid;
                } 
            } else {
                return nums[start];
            }
        }
        if (nums[start] > nums[end]) {
            return nums[end];
        } else {
            return nums[start];
        }
    }
