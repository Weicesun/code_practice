public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        
        TreeNode temp = null;
        if (root == null) {
            return temp;
        }
        TreeNode res = new TreeNode(root.val + 1);
        TreeNode pre = res;
        res.left = root;
        while (true) {
            if (root.val < value) {
                if (root.right == null) {
                    break;
                }
                pre = root;
                root = root.right;
            }
            else if (root.val > value) {
                if (root.left == null) {
                    break;
                }
                pre = root;
                root = root.left;
            } else {
                temp = root;
                break;
            }
        }
        if (temp == null) {
            return res.left;
        }
        TreeNode left = temp.left;
        if (temp.right == null) {
            pre.left = left;
        } else {
            if (pre.val > temp.val) {
                pre.left = temp.right;
            }
            else if (pre.val < temp.val) {
                pre.right = temp.right;
            }
            else if (temp == res.left) {
                res.left = temp.right;
            }
            TreeNode node = temp.right;
            while (node.left != null) {
                node = node.left;
            }
            node.left = left;
            
        }
        //res.val = 0;
        return res.left;
    }
