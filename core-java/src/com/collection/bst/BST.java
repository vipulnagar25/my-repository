package com.collection.bst;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
    public TreeNode root;

    public void insertByRecursion(int data) {
        TreeNode tempNode = new TreeNode(data);
        if(root == null) {
            root = tempNode;
        } else {
            insert(root, data);
        }
    }

    public void insertByIteration(int data) {
        if(root == null) {
            root = new TreeNode(data);
            ;
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if(currentNode.data > data) {
                if(currentNode.left == null) {
                    currentNode.left = new TreeNode(data);
                    break;
                } else {
                    queue.add(currentNode.left);
                }
            }
            if(currentNode.data < data) {
                if(currentNode.right == null) {
                    currentNode.right = new TreeNode(data);
                    break;
                } else {
                    queue.add(currentNode.right);
                }
            }
        }

    }

    public TreeNode insert(TreeNode root, int value) {
        if(root == null) {
            root = new TreeNode(value);
            return root;
        }

        if(value < root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public void preOrderByRecursion(TreeNode node) {
        if(node == null) {
            return;
        }
        System.out.print(node.data + "  ");
        preOrderByRecursion(node.left);
        preOrderByRecursion(node.right);

    }

    public TreeNode searchInBstByRecursion(TreeNode temp, int key) {
        if(temp == null || temp.data == key) {
            return temp;
        }
        if(temp.data > key) {
            return searchInBstByRecursion(temp.left, key);
        } else {
            return searchInBstByRecursion(temp.right, key);
        }


    }

    public static void main(String[] args) {
        BST bst = new BST();
        // bst.insertByRecursion(1);
        bst.insertByIteration(1);
        //System.out.println(bst.root.data);
        bst.insertByIteration(2);
        bst.insertByIteration(3);
        bst.insertByIteration(4);
        //bst.preOrderByRecursion(bst.root);
        TreeNode findOne = bst.searchInBstByRecursion(bst.root, 10);
        //System.out.println();
        if(findOne != null) {
            System.out.println(findOne.data + " got it");
        } else {
            System.out.println("NULL");
        }
    }
}
