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

    public boolean delete(int value) {
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = false;
        while ((int) current.data != value) {
            parent = current;
            if (value < (int) current.data) {
                // Move to the left if searched value is less
                current = current.left;
                isLeftChild = true;
            } else {
                // Move to the right if searched value is >=
                current = current.right;
                isLeftChild = false;
            }
            if (current == null) {
                return false;
            }
        }
        // if reached here means node to be deleted is found

        // Leaf node deletion case
        if (current.left == null && current.right == null) {
            System.out.println("Leaf node deletion case");
            // if root node is to be deleted
            if (current == root) {
                root = null;
            }
            // left child
            else if (isLeftChild) {
                parent.left = null;
            }
            // right child
            else {
                parent.right = null;
            }
        }
        // Node to be deleted has one child case
        // Node to be deleted has right child
        else if (current.left == null) {
            System.out.println("One right child deletion case");
            // if root node is to be deleted
            if (current == root) {
                root = current.right;
            }
            // if deleted node is left child
            else if (isLeftChild) {
                parent.left = current.right;
            }
            // if deleted node is right child
            else {
                parent.right = current.right;
            }
        }
        // Node to be deleted has left child
        else if (current.right == null) {
            System.out.println("One left child deletion case");
            if (current == root) {
                root = current.left;
            }
            // if deleted node is left child
            else if (isLeftChild) {
                parent.left = current.left;
            }
            // if deleted node is right child
            else {
                parent.right = current.left;
            }
        }
        // Node to be deleted has two children case
        else {
            System.out.println("Two children deletion case");
            // find in-order successor of the node to be deleted
            TreeNode successor = findSuccessor(current);
            if (current == root) {
                root = successor;
            }
            // if deleted node is left child
            else if (isLeftChild) {
                parent.left = successor;
            }
            // if deleted node is right child
            else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    // Method to find the in-order successor of the deleted node
    private TreeNode findSuccessor(TreeNode node) {
        TreeNode successor = node;
        TreeNode successorParent = node;
        // Start from the right child of the node to be deleted
        TreeNode current = node.right;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        // When In-order successor is in the left subtree
        // perform two ref changes here as we have
        // access to successorParent
        if (successor != node.right) {
            successorParent.left = successor.right;
            // applicable only when successor is not right child
            // so doing here
            successor.right = node.right;
        }
        return successor;
    }


    public static void main(String[] args) {
        BST bst = new BST();
        bst.insertByIteration(11);
        bst.insertByIteration(8);
        bst.insertByIteration(6);
        bst.insertByIteration(7);
        bst.insertByIteration(8);
        bst.insertByIteration(9);
        bst.insertByIteration(14);
       // bst.insertByIteration(13);
       // bst.insertByIteration(12);
        bst.insertByIteration(15);
//        bst.insertByIteration(1);
        bst.inOrderByIterative();
        System.out.println();
        bst.delete( 14);
        bst.inOrderByIterative();
        System.out.println();
        System.out.println(bst.root.data);
    }
}
