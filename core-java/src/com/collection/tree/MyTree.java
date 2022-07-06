package com.collection.tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyTree {
    TreeNode root;

    public void addElement(Object data) {
        TreeNode newNode = new TreeNode(data);
        if(root == null) {
            root = newNode;
        } else {
            addElementIfRootNotNull(newNode);
        }
    }

    public void addElementIfRootNotNull(TreeNode newNode) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode currentNode = root;
        queue.add(currentNode);
        while(!queue.isEmpty()) {
            currentNode = queue.peek();
            queue.remove();
            if(currentNode.left == null) {
                currentNode.left = newNode;
                break;
            } else {
                queue.add(currentNode.left);

            }
            if(currentNode.right == null) {
                currentNode.right = newNode;
                break;
            } else {
                queue.add(currentNode.right);

            }

        }

    }

    public void printTreeElement() {
        TreeNode currentNode = root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(currentNode);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(!queue.isEmpty()) {
            currentNode = queue.poll();
            sb.append(currentNode.data + ",");
            if(currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if(currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        sb.append("]");

        System.out.println(sb);
    }

    public void inOrderByIterative() {
        if(root == null) {
            return;
        }
        Stack<TreeNode> treeStack = new Stack<TreeNode>();
        TreeNode temp = root;
        while(!treeStack.isEmpty() || temp != null) {
            if(temp != null) {
                treeStack.push(temp);
                temp = temp.left;
            } else {
                temp = treeStack.pop();
                System.out.print(temp.data + "  ");
                temp = temp.right;
            }
        }
    }
    public void inOrderByRecursion(TreeNode node) {
        if(node == null) {
            return;
        }
        inOrderByRecursion(node.left);
        System.out.print(node.data + "  ");
        inOrderByRecursion(node.right);

    }
    public void preOrderByIterative() {
        if(root == null) {
            return;
        }
        Stack<TreeNode> treeStack = new Stack<TreeNode>();
        treeStack.add(root);
        while(!treeStack.isEmpty()) {
            TreeNode temp = treeStack.pop();
            System.out.print(temp.data + "  ");
            if(temp.right != null) {
                treeStack.push(temp.right);
            }
            if(temp.left != null) {
                treeStack.push(temp.left);
            }
        }
    }
    public void preOrderByRecursion(TreeNode node) {
        if(node == null) {
            return;
        }
        System.out.print(node.data + "  ");
        preOrderByRecursion(node.left);
        preOrderByRecursion(node.right);

    }

    public void postOrderByIterative() {
        if(root == null) {
            return;
        }
        Stack<TreeNode> treeStack = new Stack<TreeNode>();
        Stack<Object> out = new Stack<>();
        treeStack.add(root);
        while(!treeStack.isEmpty()) {
            TreeNode temp = treeStack.pop();
            out.push(temp.data);
            System.out.print(temp.data + "  ");
            if(temp.left != null) {
                treeStack.push(temp.left);
            }
            if(temp.right != null) {
                treeStack.push(temp.right);
            }
        }
        System.out.println();
        while(!out.empty()) {
            System.out.print(out.pop() + "");
        }
    }

    public void postOrderByRecursion(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderByRecursion(node.left);
        postOrderByRecursion(node.right);
        System.out.print(node.data + "  ");

    }


    public static void main(String[] args) {
        MyTree tree = new MyTree();
        tree.addElement(1);
        tree.addElement(2);
        tree.addElement(3);
        tree.addElement(4);
        tree.addElement(5);
        tree.addElement(6);
        tree.addElement(7);
        // tree.printTreeElement();
        // tree.inOrderByIterative();
        //tree.inOrderByRecursion(tree.root);
        //tree.preOrderByIterative();
        System.out.println();
       // tree.preOrderByRecursion(tree.root);
        tree.postOrderByRecursion(tree.root);
        System.out.println();
        tree.postOrderByIterative();
    }

}

