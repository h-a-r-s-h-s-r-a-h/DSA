package Code.CircularSinglyLinkedList.Project02;

import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {
    private ListNode last;
    private int length;

    private class ListNode {
        private ListNode next;
        private int data;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public CircularSinglyLinkedList() {
        last = null;
        length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void display() {
        if (last == null) {
            return;
        }
        ListNode first = last.next;
        while (first != last) {
            System.out.print(first.data + " ");
            first = first.next;
        }
        System.out.println(first.data);
    }

    public void insertLast(int data) {
        ListNode temp = new ListNode(data);
        if (last == null) { //isEmpty()
            last = temp;
            last.next = last;
        } else {
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
        length++;
    }

    public ListNode removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Circular Singly Linked List is already empty");
        }
        ListNode temp = last.next;
        if (last.next == last) {
            last = null;
        } else {
            last.next = temp.next;
        }
        temp.next = null;
        length--;
        return temp;
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList csll1 = new CircularSinglyLinkedList();
        csll1.insertLast(11);
        csll1.insertLast(22);
        csll1.insertLast(33);
        System.out.println("Linked List before deletion");
        csll1.display();

        System.out.println("Linked List after deletion");
        csll1.removeFirst();
        csll1.display();

    }
}
