public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        // Write your code here
        //quicksort(A, 0, A.length - 1);
        int[] temp = new int[A.length];
        mergesort(A, 0, A.length - 1, temp);
    }
    /*public void quicksort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int pivot = A[(start + end) / 2 + 1];
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[right];
                A[right] = A[left];
                A[left] = temp;
                right--;
                left++;
            }
        }
        quicksort(A, start, right);
        quicksort(A, left, end);
    }*/
    public void mergesort(int[] A, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergesort(A, start, mid, temp);
        mergesort(A, mid + 1, end, temp);
        merge(A, start, mid, end, temp);
    }
    public  void merge(int[] A, int start, int mid, int end, int[] temp) {
        int i = start;
        int j = mid + 1;
        int index = start;
        while (i <= mid && j <= end) {
            if (A[i] < A[j]) {
                temp[index] = A[i];
                index++;
                i++;
            } else {
                temp[index] = A[j];
                index++;
                j++;
            }
        }
        while (i <= mid) {
            temp[index] = A[i];
            index++;
            i++;
        }
        while (j <= end) {
            temp[index] = A[j];
            index++;
            j++;
        }
        for (int k = start; k <= end; k++) {
            A[k] = temp[k];
        }
    }
}
