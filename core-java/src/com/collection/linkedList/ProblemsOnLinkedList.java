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

    public void removeFromNthElement(MyLinkedList linkedList, int n) {
        Node fast = linkedList.head;
        Node slow = linkedList.head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            return;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

    }


    public static void main(String[] args) {
        ProblemsOnLinkedList problems = new ProblemsOnLinkedList();
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add("1");
        // linkedList.add("1");
        linkedList.add("2");
        // linkedList.add("2");
        linkedList.add("3");
        // linkedList.add("3");
        // linkedList.add("3");
        // linkedList.add("3");
        linkedList.add("4");
        // linkedList.add("4");
        linkedList.add("5");
        // linkedList.printLinkedList();
        //  problems.removeDuplicateFromSortedList(linkedList);
        // link
        // edList.printLinkedList();
        linkedList.printLinkedList();
        problems.removeFromNthElement(linkedList, 2);
        linkedList.printLinkedList();


    }
}

