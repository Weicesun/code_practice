// merge sort

    public long reversePairs(int[] A) {
        // Write your code here
       return  mergeSort(A, 0, A.length - 1);
    }
    public long mergeSort(int[] A, int start, int end) {
        if (start >= end) {
            return 0;
        } 
        long sum = 0;
        int mid = start + (end - start) / 2;
        
        sum += mergeSort(A, start, mid);
        sum += mergeSort(A, mid + 1, end);
        sum += merge(A, start, mid, end);
        return sum;
    }
    public long merge(int[] A, int start, int mid, int end) {
        int[] temp = new int[A.length];
        int leftindex = start;
        int rightindex = mid + 1;
        int index = start;
        int sum = 0;
        while (leftindex <= mid && rightindex <= end) {
            if (A[leftindex] <= A[rightindex]) {
                temp[index++] = A[leftindex++];
            } else {
                temp[index++] = A[rightindex++];
                sum += mid - leftindex + 1;
            }
        }
        while (leftindex <= mid) {
            temp[index++] = A[leftindex++];
        }
        while (rightindex <= end) {
            temp[index++] = A[rightindex++];
        }
        for (int i = start; i <= end; i++ ) {
            A[i] = temp[i];
        }
        return sum;
    }
