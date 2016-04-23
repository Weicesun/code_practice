public int kthSmallest(TreeNode root, int k) {
       int num = count(root.left);
       if (k <= num) {
           return  kthSmallest(root.left, k);
       } else if (k > num + 1){
           return kthSmallest(root.right, k - num - 1);
       }
       return root.val;
    }
    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }
