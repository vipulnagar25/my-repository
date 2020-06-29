package com.queue;

public class  Queue {

	ListNode front;
	ListNode rear;

	public void enQueue(int data) {

		ListNode newNode = new ListNode(data);
		if (front == null) {
			front = newNode;
		} else {
			rear.next = newNode;
		}
		rear = newNode;
	}

	public void deQueue() {
		if (front == null) {
			System.out.println("queue is blank and you are  deleting");
		} else {
			System.out.println("deleted data is ==" + front.data);
			front = front.next;
			if (front == null) {
				rear = null;
			}
		}
	}
	public void display() {
		ListNode currentNode = front;
		if (currentNode == null) {
			return;
		}
		while (currentNode != null) {
			System.out.print(currentNode.data + "-->");
			currentNode = currentNode.next;
		}
		System.out.println("null");
	}

	public static void main(String[] args) {
		
	Queue queue=new Queue();
	queue.enQueue(10);
   
    queue.display();
    queue.deQueue();
    queue.deQueue();
    queue.display();
	}

}
