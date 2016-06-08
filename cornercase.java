    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        List<String> res = new ArrayList<>();
        if (lower > upper) {
            return res;
        }
        if (nums == null || nums.length == 0) {
            String temp = new String();
            temp = range(lower, upper);
            res.add(temp);
            return res;
        }
        for (int i = 0; i < nums.length && nums[i] <= upper; i++) {
            if (i == 0) {
                String s1 = range(lower, nums[i] - 1);
                if (s1.length() > 0)
                res.add(s1);
            }
            if (i == nums.length - 1) {
                String s2 = range(nums[i] + 1, upper);
                if (s2.length() > 0)
                res.add(s2);
            }
            if (i >= 0 && i < nums.length - 1) {
                String s3 = range(nums[i] + 1, nums[i + 1] - 1);
                if (s3.length() > 0)
                res.add(s3);
            }
        }
        return res;
    }
    public String range(int start, int end) {
        if (start > end) {
            return "";
        }
        else if (start == end) {
            return "" + start;
        }
        else {
            return start + "->" + end;
        }
    }
