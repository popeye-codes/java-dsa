package com.shivam.treepractice;

import java.util.ArrayList;

public class BinaryTreesPaths {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public ArrayList<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        helper(root, "", list);

        return list;
    }

    public void helper(TreeNode node, String path, ArrayList<String> list) {

        if (node == null) {
            return;
        }

        if (path.isEmpty()) {
            path = "" + node.val;
        } else {
            path = path + "->" + node.val;
        }

        /// at leaf
        if (node.left == null && node.right == null) {
            list.add(path);
            return;
        }

        helper(node.right, path, list);

        helper(node.left, path, list);

    }

}
