    public String largestNumber(int[] nums) {
        String result = new String();
        if (nums == null || nums.length == 0) {
            return result;
        }
        String[] list = new String[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            list[i] = nums[i] + "";
        }
        Comparator<String> comp = new Comparator<String>() {
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s1.compareTo(s2);
            }
        };
        Arrays.sort(list, comp);
        if (list[list.length - 1].charAt(0) == '0') {
            return "0";
        }
        for (int i = list.length - 1; i >= 0; i--) {
            result = result + list[i];
        }
        return result;
    }
// Comparator<>
