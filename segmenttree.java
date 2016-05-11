 class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int sum;
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
        SegmentTreeNode root = null;
        public NumArray(int[] nums) {
            root = buildTree(nums, 0, nums.length - 1);
        }
        private buildTree(int[] nums, int start, int end) {
            if (start > end) {
                return null
            } else {
                SegmentTreeNode res = new SegmentTreeNode(start, end);
                if (start == end) {
                    res.sum = nums[start];
                } else {
                    int mid = start + (end - start) / 2;
                    res.left = new SegmentTreeNode(start, mid);
                    res.right = new SegmentTreeNode(mid + 1; end);
                    res.sum = res.left.sum + res.right.sum;
                }
            }
            return res;
        }
        public void update(int i, int val) {
            update(root, i, val);
        }
        public void update(SegmentTreeNode root, int i, int val) {
            if (root.start == root.end) {
                root.sum = val;
            } else {
                int mid = start + (end - start) / 2;
                if (i <= mid) {
                    update(root.left, i, val);
                } else {
                    update(root.right, i, val);
                }
                root.sum = root.left.sum + root.right.sum;
            }
            
        }
        public int sumRange(int i, int j) {
            return sumRange(root, i, j);
        }
        public int sumRange(SegmentTreeNode root, int start, int end) {
            if (root.end == end && root.start == start) {
                return root.sum;
            } else {
                int mid = root.start + (root.end - root.start) / 2;
                if (mid + 1 <= start) {
                    return sumRange(root.right, start, end);
                } else if (mid >= end) {
                    return sumRange(root.left, start, mid)
                }
            }
        }
    }
