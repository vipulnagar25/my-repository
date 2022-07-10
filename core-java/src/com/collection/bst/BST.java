package com.collection.bst;


import com.collection.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {
    public TreeNode root;

    public void inOrderByIterative() {
        if (root == null) {
            System.out.println("this is blank tree");
            return;
        }
        Stack<TreeNode> treeStack = new Stack<>();
        TreeNode temp = root;
        while (!treeStack.isEmpty() || temp != null) {
            if (temp != null) {
                treeStack.push(temp);
                temp = temp.left;
            } else {
                temp = treeStack.pop();
                System.out.print(temp.data + "  ");
                temp = temp.right;
            }
        }
    }

    public void insertByIteration(int data) {
        if (root == null) {
            root = new TreeNode(data);
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if ((int) currentNode.data > data) {
                if (currentNode.left == null) {
                    currentNode.left = new TreeNode(data);
                    break;
                } else {
                    queue.add(currentNode.left);
                }
            }
            if ((int) currentNode.data < data) {
                if (currentNode.right == null) {
                    currentNode.right = new TreeNode(data);
                    break;
                } else {
                    queue.add(currentNode.right);
                }
            }
        }


    }

    public static TreeNode deleteNodeIteratively(TreeNode root, int value) {
        TreeNode parent = null, current = root;
        boolean hasLeft = false;

        if (root == null)
            return root;

           while (current != null) {
            if ((int) current.data == value) {
                break;
            }
            parent = current;
            if (value < (int) current.data) {
                hasLeft = true;
                current = current.left;
            } else {
                hasLeft = false;
                current = current.right;
            }
        }


        if (parent == null) {
            return deleteNodeIteratively(current);
        }

        if (hasLeft) {
            parent.left = deleteNodeIteratively(current);
        } else {
            parent.right = deleteNodeIteratively(current);
        }

        return root;
    }

    private static TreeNode deleteNodeIteratively(TreeNode node) {

        if (node != null) {
            if (node.left == null && node.right == null) {
                return null;
            }

            if (node.left != null && node.right != null) {
                TreeNode inOrderSuccessor = deleteInOrderSuccessorDuplicate(node);
                node.data = inOrderSuccessor.data;
            } else if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return node;
    }

    private static TreeNode deleteInOrderSuccessorDuplicate(TreeNode node) {
        TreeNode parent = node;
        node = node.right;
        boolean rightChild = node.left == null;

        while (node.left != null) {
            parent = node;
            node = node.left;
        }

        if (rightChild) {
            parent.right = node.right;
        } else {
            parent.left = node.right;
        }

        node.right = null;
        return node;
    }


    public static void main(String[] args) {
        BST bst = new BST();
        bst.insertByIteration(11);
        bst.insertByIteration(8);
//        bst.insertByIteration(6);
//        bst.insertByIteration(7);
//        bst.insertByIteration(8);
        //bst.insertByIteration(9);
//        bst.insertByIteration(14);
//        bst.insertByIteration(13);
        bst.insertByIteration(12);
//       bst.insertByIteration(15);
//        bst.insertByIteration(1);
        bst.inOrderByIterative();
        System.out.println();
        bst.deleteNodeIteratively(bst.root, 11);
        bst.inOrderByIterative();
        System.out.println();
        System.out.println(bst.root.data);
    }
}
