public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int len = citations.length;
        int start = 0;
        int end = len - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (citations[mid] < len - mid) {
                start = mid;
            }
            if (citations[mid] >= len - mid ) {
                end = mid;
            }
        }
        if (citations[end] == len - end) {
            return citations[end];
        } else if (citations[start] == len - start){
            return citations[start];
        }
        return len - end - 1;
    }
// not correct
//index2
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int start = 0;
        int end = citations.length - 1;
        int e = end;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (citations[mid] < e - mid + 1) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (citations[start] >= e - start + 1) {
            return e - start + 1;
        }
        if (citations[end] >= e - end + 1) {
            return e - end + 1;
        }
        
        return 0;
    }
