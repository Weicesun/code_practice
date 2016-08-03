List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack1 = new Stack<TreeNode>();
    Stack<TreeNode> stack2 = new Stack<TreeNode>();
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        if (root == null) {
            return list;
        }
        getNextPredecessor(root, target);
        getNextSuccessor(root, target);
        while (list.size() < k) {
            if (stack1.isEmpty()) {
                list.add(stack2.pop().val);
            } else if (stack2.isEmpty()) {
                list.add(stack1.pop().val);
            } else if (target - stack1.peek().val < stack2.peek().val - target) {
                list.add(stack1.pop().val);
            } else {
                list.add(stack2.pop().val);
            }
            
        }
        return list;
    }
    
    public void getNextPredecessor(TreeNode node, double target) {
        if (node == null) {
            return;
        }
        getNextPredecessor(node.left, target);
        if (node.val >= target) {
            return;
        }
        stack1.push(node);
        getNextPredecessor(node.right, target);
    }
    public void getNextSuccessor(TreeNode node, double target) {
       if (node == null) {
            return;
        }
        getNextSuccessor(node.right, target);
        if (node.val < target) {
            return;
        }
        stack2.push(node);
        getNextSuccessor(node.left, target);
    }
