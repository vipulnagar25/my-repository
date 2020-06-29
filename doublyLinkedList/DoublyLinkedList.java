package com.doublyLinkedList;

public class DoublyLinkedList {
    public ListNode head;
    public ListNode tail;
    public int length;

    DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return this.length == 0;
        // if head or tail==null;
    }

    public int length() {
        return length;
    }

    public void firstInsertInDLL(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
    }

    public void forwardDisplay() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.println("null");

    }

    public void backwardDisplay() {
        ListNode current = tail;
        while (current != null) {
            System.out.print(current.data + "-->");
            current = current.prev;
        }
        System.out.println("null");

    }

    public void lastInsertInDLL(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }

        tail = newNode;
    }

    public void deleteFirstNodeInDDL() {
        if (head == null) {
            return;
        }
        if (head == tail) {
            tail = null;
        } else {
            head.next.prev = null;
        }
        head = head.next;

    }

    public void deleteLastNodeInDDL() {
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = null;
        } else {
            tail.prev.next = null;
        }
        tail = tail.prev;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.firstInsertInDLL(12);
        dll.firstInsertInDLL(11);
        dll.firstInsertInDLL(10);
        dll.firstInsertInDLL(9);
        dll.forwardDisplay();
        //dll.backwardDisplay();
        //dll.deleteLastNodeInDDL();
        //  dll.forwardDisplay();

    }
}

