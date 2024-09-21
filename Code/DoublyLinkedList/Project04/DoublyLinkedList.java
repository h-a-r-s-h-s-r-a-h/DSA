package Code.DoublyLinkedList.Project04;

import java.util.NoSuchElementException;

public class DoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;

    private class ListNode {
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int length() {
        return length;
    }

    public void displayForward() {
        if (head == null) {
            return;
        }
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    public void insertLast(int value) {
        ListNode newNode = new ListNode(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        length++;
    }

    public ListNode deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        ListNode temp = head;
        if (head == tail) {
            tail = null;

        } else {
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    public ListNode deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        ListNode temp = tail;
        if (head == tail) {
            head = null;
        } else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
        length--;
        return temp;
    }

    public ListNode deleteByPosition(int position) {
        if (position <= 0 || position > length) {
            throw new IndexOutOfBoundsException("Invalid position.");
        }

        if (position == 1) {
            return deleteFirst();
        }

        if (position == length) {
            return deleteLast();
        }

        ListNode current = head;
        int count = 1;

        while (count < position) {
            current = current.next;
            count++;
        }

        current.previous.next = current.next;
        current.next.previous = current.previous;

        current.next = null;
        current.previous = null;

        length--;
        return current;
    }


    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertLast(1);
        dll.insertLast(10);
        dll.insertLast(15);
        dll.insertLast(14);
        dll.insertLast(17);

        System.out.println("Linked List before Deletion :- ");
        dll.displayForward();

        System.out.println("Linked List after Deletion :- ");
        dll.deleteByPosition(3);
        dll.displayForward();

    }
}
