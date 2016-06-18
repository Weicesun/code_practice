    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (union(temp)) {
                res++;
            }
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        return res;
        
    }
    public boolean union (TreeNode node) {
        if (node == null) {
            return true;
        }
        if (node.left == null && node.right == null) {
            return true;
        }
        if (node.left != null && node.val != node.left.val) {
            return false;
        }
        if (node.right != null && node.val != node.right.val) {
            return false;
        }
        return union(node.left) && union(node.right);
    }
