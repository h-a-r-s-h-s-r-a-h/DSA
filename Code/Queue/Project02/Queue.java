package Code.Queue.Project02;

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
        private String data;
        private ListNode next;

        public ListNode(String data) {
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

    public void enqueue(String data) {
        ListNode temp = new ListNode(data);
        if (isEmpty()) {
            front = temp;
        } else {
            rear.next = temp;
        }
        rear = temp;
        length++;
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is already empty");
        }
        String result = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        length--;
        return result;
    }

    public static String[] generateBinaryNumbers(int n) {
        Queue queue = new Queue();
        String[] result = new String[n];

        queue.enqueue("1");

        for (int i = 0; i < n; i++) {
            String current = queue.dequeue();
            result[i] = current;

            queue.enqueue(current + "0");
            queue.enqueue(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        String[] binaryNumbers = generateBinaryNumbers(n);
        System.out.println("Binary numbers from 1 to " + n + ":");
        for (String binary : binaryNumbers) {
            System.out.print(binary + " ");
        }
//        for (int i = 0; i < binaryNumbers.length; i++) {
//            System.out.print(binaryNumbers[i] + " ");
//        }
    }
}
