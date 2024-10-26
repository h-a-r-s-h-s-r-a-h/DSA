package Code.Queue.Project01;

import java.util.NoSuchElementException;

public class Queue {

    private ListNode front;
    private ListNode rear;
    private int length;

    public Queue() {
        this.front = null;
        this.rear = null;
        length = 0;
    }

    private class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void enqueue(int data) {
        ListNode temp = new ListNode(data);
        if (isEmpty()) {
            front = temp;
        } else {
            rear.next = temp;
        }
        rear = temp;
        length++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is alreay empty");
        }
        int result = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        length--;
        return result;
    }

    public void print() {
        if (isEmpty()) {
            return;
        }
        ListNode current = front;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int first() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is alreay empty");
        }
        return front.data;
    }

    public int last() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is alreay empty");
        }
        return rear.data;
    }


    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(20);
        queue.print();
        System.out.println("Printing front element :- " + queue.first());
        System.out.println("Printing rear element :- " + queue.last());


        System.out.println("Deleted Node is :- " + queue.dequeue());
        queue.print();
    }
}
