public int[] singleNumber(int[] nums) {
        int sta = 0;
        for (int i = 0; i < nums.length; i++) {
            sta ^= nums[i];
        }
        int shift = 0;
        while ((sta & 1 << shift) == 0) {
            shift++;
        }
        sta = 1<<shift;
        int num1 = 0;
        int num2 = 0;
        for (int j = 0; j < nums.length; j++) {
            if ((nums[j] & sta) != 0) {
                num1 ^= nums[j];
            } else {
                num2 ^= nums[j];
            }
        }
        int[] res = {num1, num2};
        return res;
    }
