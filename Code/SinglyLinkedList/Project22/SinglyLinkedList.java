package Code.SinglyLinkedList.Project22;

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

    public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static ListNode add(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while (a != null || b != null) {
            int x = (a != null) ? a.data : 0;
            int y = (b != null) ? b.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            if (a != null) {
                a = a.next;
            }
            if (b != null) {
                b = b.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll1 = new SinglyLinkedList();
        sll1.insertLast(7);
        sll1.insertLast(4);
        sll1.insertLast(9);
        System.out.println("Displaying linked list 1 :- ");
        sll1.display();

        SinglyLinkedList sll2 = new SinglyLinkedList();
        sll2.insertLast(5);
        sll2.insertLast(6);
        System.out.println("Displaying linked list 2 :- ");
        sll2.display();

        SinglyLinkedList result = new SinglyLinkedList();
        result.head = add(sll1.head, sll2.head);
        System.out.println("Displaying Linked List After Addition :-");
        result.display();
    }
}