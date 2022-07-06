package com.collection.linkedList;

public class MyLinkedList {
    Node head;
    int listSize;

    public void add(Object data) {
        Node newNode = new Node(data);
        listSize++;
        if (head == null) {
            head = newNode;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {

                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public void printLinkedList() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node currentNode = head;

        while (currentNode != null) {
            sb.append(currentNode.data);
            if (currentNode.next != null) {
                sb.append(",");
            }
            currentNode = currentNode.next;
        }
        sb.append("]");
        System.out.println(sb.toString());

    }

    public void addAtFirst(Object data) {
        listSize++;
        Node newObject = new Node(data);
        newObject.next = head;
        head = newObject;
    }

    public void addAtLast(Object data) {
        listSize++;
        Node newObject = new Node(data);
        if (head == null) {
            head = newObject;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newObject;
        }
    }

    public Object getMiddleElement() {
        if (head == null) {
            return null;
        } else {
            Node slowPtr = head;
            Node fastPtr = head;
            while (fastPtr != null && fastPtr.next != null) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next.next;
            }
            return slowPtr.data;
        }


    }

    public void reverseLinkedList() {
        Node current = head;
        Node previous = null;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;

    }

    public void removeElement(Object kayData) {
        Node current = head;
        Node previous = null;

        while (current != null && current.data != kayData) {
            previous = current;
            current = current.next;
        }
        if (current != null) {
            listSize--;
            System.out.println(current.data);
            previous.next = current.next;
        } else
            System.out.println("there is no data");

    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("there is no data");
        } else {
            listSize--;
            head = head.next;
        }


    }

    public void removeAt(int index) {
        if (index >= listSize || listSize == 0 || index < 0) {
            System.out.println("index does not exits");
        } else {
            int count = 0;
            Node currentNode = head;
            Node previous = head;
            while (currentNode != null && count != index) {
                previous = currentNode;
                currentNode = currentNode.next;
                count++;
            }
            previous.next = currentNode.next;
            listSize--;
        }
    }


    public static void main(String[] args) {
       // Doubl
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        //  linkedList.printLinkedList();
        linkedList.addAtFirst("5");
        // linkedList.printLinkedList();
        // System.out.println(linkedList.getMiddleElement());
        linkedList.addAtLast("6");
        // linkedList.printLinkedList();
        // System.out.println(linkedList.getMiddleElement());
        // linkedList.reverseLinkedList();

        // linkedList.removeElement("2");
        //  linkedList.printLinkedList();
        //linkedList.removeFirst();
        linkedList.printLinkedList();
        System.out.println(linkedList.listSize);
        linkedList.removeAt(9);
        linkedList.printLinkedList();
        System.out.println(linkedList.listSize);
    }


}