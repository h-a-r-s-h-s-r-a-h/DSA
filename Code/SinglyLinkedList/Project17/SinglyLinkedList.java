package Code.SinglyLinkedList.Project17;

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

    public void deleteNode(int key) {
        ListNode current = head;
        ListNode temp = null;

        if (current != null && current.data == key) {
            head = current.next;
            return;
        }

        while (current != null && current.data != key) {
            temp = current;
            current = current.next;
        }

        // When key is not found
        if (current == null) {
            return;
        }

        temp.next = current.next;
    }


    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertLast(1);
        sll.insertLast(2);
        sll.insertLast(3);
        sll.insertLast(4);
        sll.insertLast(6);
        sll.display();

        sll.deleteNode(4);
        sll.display();
    }
}
