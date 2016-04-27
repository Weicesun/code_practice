public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int max = 0;
        for (int i = 1; i <= citations.length; i++) {
            if ((citations[citations.length - i] >= i) && (citations.length == i || citations[citations.length - i - 1] <= i)) {
                //max = Math.max(i, max);
                return i;
            }
        }
        return 0;
    }
