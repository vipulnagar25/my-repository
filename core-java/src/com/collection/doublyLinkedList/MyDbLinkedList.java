package com.collection.doublyLinkedList;

public class MyDbLinkedList {
    Node head;
    Node last;
    int size;

    public void addElement(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;

        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            newNode.prev = currentNode;
            currentNode.next = newNode;

        }
        last = newNode;
        size++;
    }

    public void printDbLinkedList() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (size == 0) {
        } else {
            Node currentNode = head;
            while (currentNode != null) {
                sb.append(currentNode.data + ",");
                currentNode = currentNode.next;
            }
            sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(",") + 1, "");
        }

        sb.append("]");
        System.out.println(sb.toString());
    }

    public void printReverseDbLinkedList() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (size == 0) {
        } else {
            Node currentNode = last;
            while (currentNode != null) {
                sb.append(currentNode.data + ",");
                currentNode = currentNode.prev;
            }
            sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(",") + 1, "");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public void addElementAtFirst(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            last = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;

        }
        size++;
    }

    public void addElementAtLast(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            last = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;

        }
        size++;
    }

    public void deleteAtFirst() {
        if (size == 0) {
            System.out.println("Nothing there to delete");
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    public void deleteAtLast() {
        if (size == 0) {
            System.out.println("Nothing there to delete");
        } else {
            last = last.prev;
            last.next = null;
        }
        size--;
    }

    public static void main(String[] args) {
        MyDbLinkedList dbLinkedList = new MyDbLinkedList();
        dbLinkedList.addElement("1");
        dbLinkedList.addElement("2");
        dbLinkedList.addElement("3");
        dbLinkedList.addElementAtFirst("0");
        dbLinkedList.addElementAtLast("4");
        System.out.println(dbLinkedList.size);
        dbLinkedList.printDbLinkedList();
        dbLinkedList.deleteAtLast();
        dbLinkedList.printDbLinkedList();
        //  dbLinkedList.printReverseDbLinkedList();
        System.out.println(dbLinkedList.size);
    }

}
