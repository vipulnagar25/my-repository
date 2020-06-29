package com.stack;

public class Stack {
    private ListNode top;

    public void push(int data) {
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
    }

    public void display() {
        if (top == null) {
            return;
        }
        ListNode current = top;
        while (current != null) {
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void pop() {
        ListNode current = top;
        if (top == null) {
            return;
        }
        System.out.println("deleled element" + current.data);
        top = current.next;
    }


    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(10);
        st.push(12);
        st.push(13);
        st.display();
        st.pop();
        st.pop();
        st.display();
    }

}
