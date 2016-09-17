/* PLEASE DO NOT UNCOMMENT THIS BLOCK

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;
// No other imports are permitted

// The following definitions of Tree and Node are provided.
// insert and delete will be methods of class Tree.

public class Tree {
    private class Node {
        private int val;
        private Node left = null;
        private Node right = null;
        private Node mid = null;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;
*/ 

    /* 
     * Please complete this method.
     * Inserts val into the tree.
     */
    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
            return;
        }
        helper(root, val);
    }
    public void helper(Node root, int val) {
        if (root == null) {
            return;
        }
        if (root.val == val) {
            if (root.mid != null) {
                helper(root.mid, val);
            } else {
                root.mid = new Node(val);
            }
        } else if (root.val < val) {
            if(root.right != null) {
                helper(root.right, val);
            } else {
                root.right = new Node(val);
            }
        } else  {
            if (root.left != null) {
                helper(root.left, val);
            } else {
                root.left = new Node(val);
            }
        }
    }

    /* 
     * Please complete this method.
     * Deletes only one instance of val from the tree.
     * If val does not exist in the tree, do nothing.
     */
    public void delete(int val) {
        helperD(root, val);
    }
    public Node helperD(Node root, int value) {
        if (root == null) {
            return null;
        }
        if (root.val > value) {
            root.left = helperD(root.left, value);
        } else if(root.val < value) {
            root.right = helperD(root.right, value);
        } else {
            if (root.mid != null) {
                root.mid = helperD(root.mid, value);
            } else if(root.right != null) {
                int min = minimum(root.right).val;
                root.val = min;
                root.right = helperD(root.right, min);
            } else {
                root = root.left;
            }
        }
        return root;
    }
    public Node minimum(Node root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    


