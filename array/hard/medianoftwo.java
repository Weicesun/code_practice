public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left = (nums1.length + nums2.length + 1) / 2;
        int right = (nums1.length + nums2.length + 2) / 2;
        int m = nums1.length;
        int n = nums2.length;
        return (findKth(nums1, nums2, m, n, left) +findKth(nums1, nums2, m, n, right)) / 2.0;
    }
    public int findKth(int nums1[], int nums2[], int m, int n, int k) {
        if (m == 0) {
            return nums2[k - 1];
        }
        if (n == 0) {
            return nums1[k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[0], nums2[0]);
        }
        int p = Math.min(k / 2, m);
        int q = Math.min(k / 2, n);
        if (nums1[p - 1] < nums2[q - 1]) {
            return findKth(Arrays.copyOfRange(nums1, p, nums1.length), nums2, m - p, n, k - p);
        } else {
            return findKth(nums1, Arrays.copyOfRange(nums2, q, nums2.length), m, n - q, k - q);
        }
    }
