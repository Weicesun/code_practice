public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int h = height(root);
        int node = 0;
        while (root != null) {
            if (height(root.right) == h - 1) {
                node += 1 << h;
                root = root.right;
            } else {
                node += 1<< (h - 1);
                root = root.left;
            }
            h--;
        }
        return node;
    }
    private int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
