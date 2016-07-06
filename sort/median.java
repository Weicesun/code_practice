public int median(int[] nums) {
        // write your code here
        int len = nums.length;
        return helper(nums, 0, len - 1, (len + 1) / 2);
    }
    public int helper(int[] nums, int start, int end, int size) {
        int mid = (end + start) / 2;
        int pivot = nums[mid];
        int i = start - 1;
        int j = end + 1;
        for (int k = start; k < j; k++) {
            if (nums[k] < pivot) {
                i++;
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
            }
            else if (nums[k] > pivot) {
                j--;
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
                //j--;
                k--;
            }
        }
        if (i - start + 1 >= size) {
            return helper(nums, start,i , size );
        }
        if (j - start>= size) {
            return nums[j - 1];
        } else {
            return helper(nums, j, end, size - (j - start ));
        }
    }
