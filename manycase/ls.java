public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        List<Integer> temp = wsum(array, 3);
        for (int ele : temp) {
            System.out.println(ele);
        }
    }
    public static List<Integer> wsum(int[] array, int k) {
        int tempsum = 0;
        int start = 0;
        int end = 0;
        List<Integer> list = new ArrayList<>();
        while (end < k) {
            tempsum += array[end];
            end++;
        }
        while (end <= array.length) {
            list.add(tempsum);
            if (end == array.length) {
                break;
            }
            tempsum += array[end];
            tempsum -= array[start];
            end++;
            start++;
        }
        return list;
    }
