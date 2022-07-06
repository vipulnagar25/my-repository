package com.collection.tree;

public class TreeNode {
    TreeNode left;
    Object data;
    TreeNode right;
    int hd;
    int level;

    public TreeNode(Object data) {
        left = null;
        this.data = data;
        right = null;
    }
}
