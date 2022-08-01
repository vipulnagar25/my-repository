package com.collection.linkedList;


public class ProblemsOnLinkedList {
    public void removeDuplicateFromSortedList(MyLinkedList linkedList) {
        Node currentNode = linkedList.head;
        while (currentNode != null && currentNode.next != null) {
            if (currentNode.data == currentNode.next.data) {
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }
    }

    public boolean isCyclic(MyLinkedList linkedList) {
        Node slowPointer = linkedList.head;
        Node fastPointer = linkedList.head;
        if (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        ProblemsOnLinkedList problems = new ProblemsOnLinkedList();
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add("1");
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("3");
        linkedList.add("3");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("4");
        linkedList.add("5");
       // linkedList.printLinkedList();
        problems.removeDuplicateFromSortedList(linkedList);
        linkedList.printLinkedList();
        System.out.println(problems.isCyclic(linkedList));


    }
}
