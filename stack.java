public TreeNode maxTree(int[] A) {
        // write your code here
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (A == null || A.length == 0) {
            return null;
        }
        int len = A.length - 1;
        TreeNode node = new TreeNode(A[0]);
        for (int i = 0; i <= A.length; i++) {
            TreeNode right = i == A.length ? new TreeNode(Integer.MAX_VALUE) :
            new TreeNode(A[i]);
            while (!stack.isEmpty()) {
                if (right.val > stack.peek().val) {
                    TreeNode temp = stack.pop();
                    if (stack.isEmpty()) {
                        right.left = temp;
                    } else {
                        TreeNode left = stack.peek();
                        if (left.val > right.val) {
                            right.left = temp;
                        } else {
                            left.right = temp;
                        }
                    }
                } else {
                    break;
                }
            }
            stack.push(right);
        }
        
    }
