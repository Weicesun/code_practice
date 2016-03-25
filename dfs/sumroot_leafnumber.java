public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        ArrayList<String> list = new ArrayList();
        String temp = new String();
        
        dfs(list, temp, root);
        for (int i = 0; i < list.size(); i++) {
            String element = list.get(i);
            sum += Integer.parseInt(element);
        }
        return sum;
    }
    private void dfs(ArrayList<String> list, String temp, TreeNode root) {
        temp = temp + "" + root.val;
        if (root.left != null) {
            dfs(list, temp, root.left);
        }
        if (root.right != null) {
            dfs(list, temp, root.right);
        }
        if (root.left == null && root.right == null) {
            list.add(temp);
            temp.substring(0, temp.length() - 1);
            return;
        }
    }
