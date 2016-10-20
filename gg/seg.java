class SegmentTreeNode {
        SegmentTreeNode left;
        SegmentTreeNode right;
        int start, end;
        int sum;
        public SegmentTreeNode(int s, int e) {
            this.start = s;
            this.end = e;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }
    SegmentTreeNode root;
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
    SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            SegmentTreeNode res = new SegmentTreeNode(start, end);
            if (start == end) {
                res.sum = nums[end];
                return res;
            }
            int mid = start + (end - start) / 2;
            res.left = buildTree(nums, start, mid);
            res.right = buildTree(nums, mid + 1, end);
            res.sum = res.left.sum + res.right.sum;
            return res;
        }
    }
    void update(int i, int val) {
        updateNode(root, i, val);
    }
    void updateNode(SegmentTreeNode root, int i, int val) {
        if (root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (mid < i) {
                updateNode(root.right, i, val);
            } else {
                updateNode(root.left, i, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumNode(root, i, j);
    }
    int sumNode(SegmentTreeNode root, int i, int j) {
        if (root.start == i && root.end == j) {
            return root.sum;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (j <= mid) {
            return sumNode(root.left, i, j);
        } else if (i > mid) {
            return sumNode(root.right, i, j);
        } else {
            return sumNode(root.right, mid + 1, j) + sumNode(root.left, i, mid);
        }
    }
