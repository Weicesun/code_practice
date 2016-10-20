public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        if (len % 2 == 0) {
            return (helper(nums1, nums2, 0, 0, len / 2) + 
            helper(nums1, nums2, 0, 0, len / 2 + 1)) / 2.0;
        } else {
            return helper(nums1, nums2, 0, 0, len / 2 + 1);
        }
    }
    double helper(int[] nums1, int[] nums2, int start1, int start2, int offset) {
        if (start1 == nums1.length) {
            return nums2[start2 + offset - 1];
        }
        if (start2 == nums2.length) {
            return nums1[start1 + offset - 1];
        }
        if (offset == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int numA = start1 + offset / 2 - 1 < nums1.length ? nums1[start1 + offset / 2 - 1] : Integer.MAX_VALUE;
        int numB = start2 + offset / 2 - 1 < nums2.length ? nums2[start2 + offset / 2 - 1] : Integer.MAX_VALUE;
        if (numA < numB) {
            return helper(nums1, nums2, start1 + offset / 2, start2, offset - offset / 2);
            
        }
        return helper(nums1, nums2, start1, start2 + offset / 2, offset - offset / 2);
    }
