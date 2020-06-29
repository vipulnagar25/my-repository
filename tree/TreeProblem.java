package com.tree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TreeProblem {

    public static void findHeightOfTreeByIterative(TreeNode node) {
        if (node == null) {
            System.out.println("Height is = 1");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int max_length = 0;
        TreeNode front;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                front = queue.poll();
                if (front.left != null) {
                    queue.add(front.left);
                }
                if (front.right != null) {
                    queue.add(front.right);
                }
            }
            max_length++;
        }
        System.out.println("Height is = " + max_length);

    }

    public static int findHeightOfTreeByRecursion(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1+ Math.max(findHeightOfTreeByRecursion(node.left), findHeightOfTreeByRecursion(node.right));
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
//        TreeNode fourth = new TreeNode(4);
//        TreeNode fifth = new TreeNode(5);
//        TreeNode sixth = new TreeNode(6);
//        TreeNode seventh = new TreeNode(7);
//        TreeNode eighth = new TreeNode(8);
//        TreeNode ninth = new TreeNode(9);
        tree.root = first;
        first.left = second;
        first.right = third;
//        second.left = fourth;
//        third.right = fifth;
//        second.right = sixth;
//        sixth.right = seventh;
//        seventh.right = eighth;
//        eighth.right = ninth;
        findHeightOfTreeByIterative(tree.root);
        System.out.println(findHeightOfTreeByRecursion(tree.root));
    }
}
