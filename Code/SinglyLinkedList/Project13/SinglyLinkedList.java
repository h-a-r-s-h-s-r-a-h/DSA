package Code.SinglyLinkedList.Project13;

public class SinglyLinkedList {
    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void insertLast(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while (null != current.next) {
            current = current.next;
        }
        current.next = newNode;
    }

    public ListNode getNthNodeFromStart(int n) {
        if (head == null) {
            return null;
        }
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid value: n = " + n);
        }

        ListNode current = head;
        int count = 1;

        while (current != null && count < n) {
            current = current.next;
            count++;
        }

        if (current == null) {
            throw new IllegalArgumentException(n + " is greater than the number of nodes in the list");
        }

        return current;
    }


    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertLast(11);
        sll.insertLast(8);
        sll.insertLast(1);
        sll.insertLast(12);
        sll.insertLast(13);
        sll.display();

        ListNode nthNodeFromStart = sll.getNthNodeFromStart(2);
        System.out.println("Nth node from end is - " + nthNodeFromStart.data);

    }
}
