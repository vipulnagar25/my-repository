package com.collection.tree;

public class TreeNode {
   public TreeNode left;
    public Object data;
    public  TreeNode right;
    public int hd;
    public int level;

    public TreeNode(Object data) {
        left = null;
        this.data = data;
        right = null;
    }
}
