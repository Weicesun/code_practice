public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> list = new ArrayList<>();
        if (root == null) {
            return null;
        }
        helper(root, list);
        int ind = list.indexOf(p);
        if (ind == list.size() - 1) {
            return null;
        }
        return list.get(ind + 1);
    }
    public void helper(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        helper(root.left, list);
        list.add(root);
        helper(root.right, list);
    }
