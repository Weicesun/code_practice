public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int index1 = 0;
        int index2 = 0;
        return helper(index1, index2, preorder.length - 1, preorder, inorder);
    }
    public TreeNode helper( int index1, int index2, int end, int[] preorder, int[] inorder) {
        int length = 0;
        
        
        if (index1 >= preorder.length || index2 > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index1]);
        for (int i = index2; i <= end; i++) {
            if (inorder[i] == root.val) {
                length = i;
                break;
            }
        }
        root.left = helper(index1 + 1, index2, length - 1, preorder, inorder);
        root.right = helper(index1 + length - index2 + 1, length + 1, end, preorder, inorder);
        return root;
    }
}
