int level = 0;
    public int longestConsecutive(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }
        helper(result, root, root.val);
        return level;
    }
    public void helper(int result, TreeNode root, int target) {
        if (root == null) {
            return;
        }
        if (root.val == target) {
            result++;
        } else {
            result = 1;
        }
        level = Math.max(level, result);
        helper(result, root.left, root.val + 1);
        helper(result, root.right, root.val + 1);
       
    }
