package Code.DoublyLinkedList.Project02;

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

    public void displayBackward() {
        if (tail == null) {
            return;
        }
        ListNode temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.previous;
        }
        System.out.println("null");
    }

    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
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

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        System.out.println("Inserting node at beginning");
        dll.insertFirst(1);
        dll.insertFirst(2);
        dll.insertFirst(3);
        System.out.print("Printing Forward :- ");
        dll.displayForward();
        System.out.print("Printing Backward :- ");
        dll.displayBackward();
        System.out.println("Length :- " + dll.length());

        System.out.println();

        DoublyLinkedList dll1 = new DoublyLinkedList();
        System.out.println("Inserting node at end");
        dll1.insertLast(11);
        dll1.insertLast(22);
        dll1.insertLast(33);
        dll1.insertLast(44);
        System.out.print("Printing Forward :- ");
        dll1.displayForward();
        System.out.print("Printing Backward :- ");
        dll1.displayBackward();
        System.out.println("Length :- " + dll1.length());
    }
}
