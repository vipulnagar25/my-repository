package com.collection.doublyLinkedList;

public class Node {
    public Object data;
    public Node next;
    public Node prev;

    public Node(Object data) {
        this.data = data;
        next = null;
        prev = null;

    }
}
