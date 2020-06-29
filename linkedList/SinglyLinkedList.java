package com.linkedList;

import java.util.LinkedList;

public class SinglyLinkedList {
    private ListNode head;

    public void displayList() {
        ListNode current = head;
        while (current != null) {
            System.out.println("value of list varible" + current.data);
            current = current.next;
        }
        System.out.println("null");
    }

    public void insertFirst(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;

    }

    public void insertLast(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while (null != current.next) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void reverse() {
        if (head == null) {
            return;
        }

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;

    }

    public ListNode getMiddleNode() {
        if (head == null) {
            return null;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public ListNode getNthElement(int n) {
        ListNode mainPtr = head;
        ListNode refPtr = head;
        int count = 0;
        while (count < n) {
            refPtr = refPtr.next;
            count++;
        }
        System.out.println(refPtr.data + "dddd");
        while (refPtr != null) {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    public void removeduplicateFromSortLinkedList() {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }

        }
//head=current;

    }

    public void insertintoSortLinkedList(int value) {
        if (head == null) {
            return;
        }
        ListNode currnet = head;
        ListNode tempNode = null;
        ListNode newNode = new ListNode(value);
        while (currnet != null && currnet.data < newNode.data) {
            tempNode = currnet;
            currnet = currnet.next;
        }
        newNode.next = currnet;
        tempNode.next = newNode;
    }

    public void removeLinkedList(int key) {
        ListNode current = head;
        ListNode temp = null;
        while (current != null && current.data != key) {
            temp = current;
            current = current.next;
        }
        if (current == null) {
        return;
        }
        temp.next = current.next;
    }


    public static void main(String[] args) {
        LinkedList ee=new LinkedList();
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.insertLast(1);
        sl.insertLast(2);
        sl.insertLast(3);
        sl.insertLast(4);
        sl.insertLast(5);
        sl.insertLast(6);
        sl.insertLast(7);
        sl.insertLast(8);
        sl.insertLast(9);
        sl.insertLast(10);
        sl.insertLast(11);
        sl.insertLast(12);

        //System.out.println( sl.getMiddleNode().data+"ckkk");
        //sl.displayList();
        //sl.reverse();
       // sl.displayList();
        ListNode ln= sl.getNthElement(2);
        System.out.println(ln.data);
        //sl.removeduplicateFromSortLinkedList();
        //sl.insertintoSortLinkedList(11);
        //sl.removeLinkedList(10);
        //sl.displayList();
    }

}
