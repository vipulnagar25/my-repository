package com.collection.tree;

import java.util.*;

public class TreeProblem {

    public void printTreeNodeByLevel(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            System.out.print(currentNode.data + "-->");
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

    }

    public static void printHeightOfTree(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int max_length = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            max_length++;
        }
        System.out.println("Height Of tree is ====>" + max_length);

    }

    public static int findHeightOfTreeByRecursion(TreeNode node) {
        if (node == null)
            return -1;
        return 1 + Math.max(findHeightOfTreeByRecursion(node.left), findHeightOfTreeByRecursion(node.right));

    }

    public static void topViewByIterative(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Map<Integer, TreeNode> topViewMap = new TreeMap<Integer, TreeNode>();
        if (node == null) {
            System.out.println("this binary tree is blank");
        } else {
            node.hd = 0;
            queue.add(node);
        }
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (!topViewMap.containsKey(currentNode.hd)) {
                topViewMap.put(currentNode.hd, currentNode);
            }
            if (currentNode.left != null) {
                currentNode.left.hd = currentNode.hd - 1;
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                currentNode.right.hd = currentNode.hd + 1;
                queue.add(currentNode.right);
            }
        }
        topViewMap.forEach((key, value) -> {
            System.out.print(value.data + " ");
        });

    }

    public static void leftViewByIterative(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Map<Integer, TreeNode> leftViewMap = new TreeMap<Integer, TreeNode>();
        if (node != null) {
            node.level = 0;
            queue.add(node);
        }
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (!leftViewMap.containsKey(currentNode.level)) {
                leftViewMap.put(currentNode.level, currentNode);
            }
            if (currentNode.left != null) {
                currentNode.left.level = currentNode.level + 1;
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                currentNode.right.level = currentNode.level + 1;
                queue.add(currentNode.right);
            }
        }
        leftViewMap.forEach((key, value) -> {
            System.out.print(value.data + " ");
        });

    }

    public static void rightViewByIterative(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Map<Integer, TreeNode> rightViewMap = new TreeMap<Integer, TreeNode>();
        if (node != null) {
            node.level = 0;
            queue.add(node);
        }
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            rightViewMap.put(currentNode.level, currentNode);

            if (currentNode.left != null) {
                currentNode.left.level = currentNode.level + 1;
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                currentNode.right.level = currentNode.level + 1;
                queue.add(currentNode.right);
            }
        }
        rightViewMap.forEach((key, value) -> {
            System.out.print(value.data + " ");
        });

    }

    public static void printLeaFNode(TreeNode node) {
        if (node != null) {
            printLeaFNode(node.left);
            if (node.left == null && node.right == null) {
                System.out.print(node.data + " ");
            }
            printLeaFNode(node.right);
        }

    }

    public static void printLeaFNodeByIterative(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.left == null && currentNode.right == null) {
                System.out.print(currentNode.data + " ");
            }
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

    }

    public void printZigZagTree(TreeNode root, boolean isLeft) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            while (size-- > 0) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
                temp.add((Integer) currentNode.data);

            }
            if (isLeft) {
                Collections.reverse(temp);
                isLeft = false;
            } else
                isLeft = true;
            ans.addAll(temp);

        }
        System.out.println(ans);
    }
    public boolean isSymmetric(TreeNode root)
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        while (!q.isEmpty())
        {
            TreeNode tempLeft = q.remove();
            TreeNode tempRight = q.remove();
            if (tempLeft==null && tempRight==null)
                continue;
            if ((tempLeft==null && tempRight!=null) ||
                    (tempLeft!=null && tempRight==null))
                return false;
            if (tempLeft.data != tempRight.data)
                return false;
            q.add(tempLeft.left);
            q.add(tempRight.right);
            q.add(tempLeft.right);
            q.add(tempRight.left);
        }

        /* if the flow reaches here, return true*/
        return true;
    }

    public static void main(String[] args) {
        MyTree tree = new MyTree();
        tree.addElement(1);
        tree.addElement(2);
        //tree.addElement(3);
        // tree.addElement(4);
        //tree.addElement(5);
        //tree.addElement(6);
        //tree.addElement(7);
        //   tree.addElement(8);
        //TreeProblem treeProblem = new TreeProblem();
        //treeProblem.printTreeNodeByLevel(tree.root);
        System.out.println(findHeightOfTreeByRecursion(tree.root));
        printHeightOfTree(tree.root);
        System.out.println("vipul");
        topViewByIterative(tree.root);
        System.out.println();
        System.out.println("=================================");
        leftViewByIterative(tree.root);
        System.out.println();
        System.out.println("=================================");
        rightViewByIterative(tree.root);
        System.out.println();
        System.out.println("=================================");
        printLeaFNode(tree.root);
        System.out.println();
        System.out.println("=================================");
        printLeaFNodeByIterative(tree.root);
    }
}
