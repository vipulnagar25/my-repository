package com.collection.circularSinglyLinkedList;

public class CircularSinglyLinkedList {
    public ListNode last;

    public CircularSinglyLinkedList() {
        last = null;
    }

    public void insertFirstCSLL(int data) {
        ListNode temp = new ListNode(data);
        if (last == null) {
            last = temp;
        } else {
            temp.next = last.next;
        }
        last.next = temp;
        System.out.println(last);
    }

    public void insertLastCSLL(int data) {
        ListNode temp = new ListNode(data);
        if (last == null) {
            last = temp;
            last.next = temp;
        } else {
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
    }

    public void removeFirstCSLL() {
        //ListNode temp = new ListNode(data);
        if (last == null) {
            return;
        }
        ListNode first = last.next;
        if (last.next == last) {
            last = null;

        } else {
            last.next = first.next;
            first = null;
        }

    }


    public void display() {
        if (last == null) {
            return;
        }

        ListNode first = last.next;
        System.out.println(last.next.data);
        while (first != last) {
            System.out.print(first.data + " --> ");
            first = first.next;
        }
        System.out.println(first.data);
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
      //  csll.insertFirstCSLL(10);
        //csll.insertFirstCSLL(11);
        csll.insertLastCSLL(12);
       csll.insertLastCSLL(13);
        //csll.removeFirstCSLL();
        csll.display();

    }

}