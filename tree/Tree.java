package com.tree;

import java.util.*;

public class Tree {
    public TreeNode root;
    public static TreeMap<Integer, TreeNode> treeMap = new TreeMap<>();

    public void insert(int data) {
        TreeNode tempNode = new TreeNode(data);
        if (root == null) {
            root = tempNode;
        } else {
            addElement(data, root);
        }
    }

    public void addElement(int data, TreeNode current) {
        TreeNode tempNode = new TreeNode(data);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(current);
        while (!queue.isEmpty()) {
            current = queue.peek();
            queue.remove();
            if (current.left == null) {
                current.left = tempNode;
                break;
            } else {
                queue.add(current.left);
            }
            if (current.right == null) {
                current.right = tempNode;
                break;
            } else {
                queue.add(current.right);
            }
        }
    }

    public void preOrderByRecursion(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + "  ");
        preOrderByRecursion(node.left);
        preOrderByRecursion(node.right);

    }

    public void preOrderByIterative() {
        if (root == null) {
            return;
        }
        Stack<TreeNode> treeStack = new Stack<TreeNode>();
        treeStack.push(root);
        while (!treeStack.isEmpty()) {
            TreeNode temp = treeStack.pop();
            System.out.print(temp.data + "  ");
            if (temp.right != null) {
                treeStack.push(temp.right);
            }
            if (temp.left != null) {
                treeStack.push(temp.left);
            }

        }

    }

    public void inOrderByRecursion(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderByRecursion(node.left);
        if (node.data == 1) {
            System.out.println("vipul");
        }
        System.out.print(node.data + "  ");
        inOrderByRecursion(node.right);

    }

    public void inOrderByIterative() {
        if (root == null) {
            return;
        }
        Stack<TreeNode> treeStack = new Stack<TreeNode>();
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

    public void postOrderByRecursion(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderByRecursion(node.left);
        postOrderByRecursion(node.right);
        System.out.print(node.data + "  ");

    }

    public void postOrderByIterative() {
        if (root == null) {
            return;
        }
        Stack<TreeNode> treeStack = new Stack<TreeNode>();
        treeStack.push(root);
        TreeNode temp = root;
        while (!treeStack.isEmpty() && temp != null) {
            if (temp.left != null) {
                treeStack.push(temp.left);
                temp = temp.left;
            } else {
                temp = treeStack.pop();
                System.out.print(temp.data + "  ");
                temp = temp.right;
            }
        }
    }

    public void traversalByLevel() {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.data + "-->");
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        System.out.print("null");
    }

    public static void topView(TreeNode node, int hd, int level) {
        if (node == null) {
            return;
        }
        node.level = level;
        if (!treeMap.containsKey(hd) || (treeMap.get(hd) != null && treeMap.get(hd).level > level)) {
            treeMap.put(hd, node);
        }
        if (node.left != null)
            topView(node.left, hd - 1, level + 1);
        if (node.right != null)
            topView(node.right, hd + 1, level + 1);
    }

    private static void TopViewByIterative(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Map<Integer, TreeNode> topViewMap = new TreeMap<Integer, TreeNode>();
        if (root == null) {
            return;
        } else {
            root.hd = 0;
            q.add(root);
        }
        while (!q.isEmpty()) {
            TreeNode tmpNode = q.poll();
            if (!topViewMap.containsKey(tmpNode.hd)) {
                topViewMap.put(tmpNode.hd, tmpNode);
            }

            if (tmpNode.left != null) {
                tmpNode.left.hd = tmpNode.hd - 1;
                q.add(tmpNode.left);
            }
            if (tmpNode.right != null) {
                tmpNode.right.hd = tmpNode.hd + 1;
                q.add(tmpNode.right);
            }
        }
        for (Map.Entry<Integer, TreeNode> entry : topViewMap.entrySet()) {
            System.out.print(entry.getValue().data);
        }
    }

    public void leftViewByIterative(TreeNode root) {
        int max_level = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root == null) {
            return;
        } else {
            root.level = 1;
            q.add(root);
        }
        while (!q.isEmpty()) {
            TreeNode tempNode = q.poll();

            if (max_level < tempNode.level) {
                System.out.print(" check" + tempNode.data);
                max_level = tempNode.level;
            }
            if (tempNode.left != null) {
                tempNode.left.level = tempNode.level + 1;
                q.add(tempNode.left);
            }
            if (tempNode.right != null) {
                tempNode.right.level = tempNode.level + 1;
                q.add(tempNode.right);
            }

        }
    }

    public static void leftBoundaryElementOfTree(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        if (rootNode.left != null) {
            System.out.print(rootNode.data + "-->");
            leftBoundaryElementOfTree(rootNode.left);
        } else if (rootNode.right != null) {
            System.out.print(rootNode.data + "-->");
            leftBoundaryElementOfTree(rootNode.right);
        }

    }

    public static void rightBoundaryElementOfTree(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        if (rootNode.right != null) {
            leftBoundaryElementOfTree(rootNode.right);
            System.out.print(rootNode.data + "-->");

        } else if (rootNode.left != null) {
            leftBoundaryElementOfTree(rootNode.left);
            System.out.print(rootNode.data + "-->");

        }

    }

    public static void printLeaves(TreeNode node) {
        if (node != null) {
            printLeaves(node.left);

            // Print it if it is a leaf node
            if (node.left == null && node.right == null)
                System.out.print(node.data + "-->");
            printLeaves(node.right);
        }
    }

    public static void printBoundaryElementByRecursion(TreeNode node) {
        System.out.print(node.data + "-->");
        leftBoundaryElementOfTree(node.left);
        printLeaves(node.left);
        printLeaves(node.right);
        rightBoundaryElementOfTree(node.right);
        System.out.println("<----done-->");

    }


    public static void main(String[] args) {

/*		Tree tree = new Tree();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(7);*/
        Tree tree = new Tree();
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);
        TreeNode seventh = new TreeNode(7);
        TreeNode eighth = new TreeNode(8);
        TreeNode ninth = new TreeNode(9);
        tree.root = first; // root ---> first
        first.left = second;
        first.right = third; // second <--- root ---> third
        second.left = fourth;
        third.right = fifth;
        second.right = sixth;
        sixth.right = seventh;
        seventh.right = eighth;
        eighth.right = ninth;
       /* System.out.println("done");
          tree.preOrderByRecursion(tree.root);
          TopViewByIterative(tree.root);
          System.out.println(treeMap);
          System.out.println();
         topView(tree.root, 0, 0);
         treeMap.forEach((k, v) -> {
           System.out.println(v.data);
         }); */

        // tree.preOrderByIterative();
        //tree.inOrderByRecursion(tree.root);
        // System.out.println();
        // tree.inOrderByIterative();
        // System.out.println();
        // tree.postOrderByRecursion(tree.root);
        // System.out.println();
        // tree.postOrderByIterative();
        //	tree.traversalByLevel();
        // tree.leftViewByIterative(tree.root);
        printBoundaryElementByRecursion(tree.root);
    }

}
