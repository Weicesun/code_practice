public int[] singleNumber(int[] nums) {
        int diff = 0;
        for(int n : nums) {
            diff ^= n;
        }
        diff = (diff&-diff);
        int[] result = {0, 0};
        for (int n : nums) {
            if ((n&diff) == 0) {
                result[0] ^= n;
            } else {
                result[1] ^= n;
            }
        }
        return result;
    }
