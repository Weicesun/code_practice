 public void nextPermutation(int[] nums) {
        int flag = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                flag = i;
            }
        }
        
        if (flag == -1) {
            reverse(0, nums.length - 1, nums);
        } else {
            int temp = flag + 1;
            int val = nums[flag + 1];
            for (int j = flag + 1; j < nums.length; j++) {
                if (nums[j] > nums[flag] && nums[j] <= val) {
                    temp = j;
                    val = nums[j];
                }
            }
            swap(flag, temp, nums);
            reverse(flag + 1, nums.length - 1, nums);
        }
        
    }
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int i, int j , int[] nums) {
        while (i < j) {
            swap(i, j, nums);
            i++;
            j--;
        }
    }
