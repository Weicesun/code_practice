 public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode p = root;
        TreeNode rootright = null;
        TreeNode parent = null;
        while (p != null) {
            TreeNode temp = p.left;
            p.left = rootright;
            rootright = p.right;
            p.right = parent;
            parent = p;
            p = temp;
            
        }
        return parent;
    }
