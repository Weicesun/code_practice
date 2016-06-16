public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 0) {
            return false;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer min = set.ceiling(nums[i] - t);
            Integer max = set.floor(nums[i] + t);
            if ((min != null && min <= nums[i]) || (max != null && max >= nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (i >= k) {
                set.remove(Integer.valueOf(nums[i - k]));
            }
        }
        return false;
    }
