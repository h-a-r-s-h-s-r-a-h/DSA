package Code.SinglyLinkedList.Project06;

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
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void insertLast(int value) {
        ListNode newNode = new ListNode(value);
        if(head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while(null != current.next) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void insert(int position, int value) {
        ListNode node = new ListNode(value);
        if(position == 1) {
            node.next = head;
            head = node;
        } else {
            ListNode previous = head;
            int count = 1;

            while(count < position-1) {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = node;
            node.next = current;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertLast(11);
        sll.insertLast(8);
        sll.insertLast(1);
        System.out.println("Linked list before insertion :- ");
        sll.display();

        System.out.println("Linked list after insertion :- ");
        sll.insert(3,16);
        sll.display();

        System.out.println();

        System.out.println("second linked list");
        SinglyLinkedList sll2 = new SinglyLinkedList();
        sll2.insert(1,11);
        sll2.insert(2,22);
        sll2.insert(3,33);
        sll2.insert(1,44);
        sll2.display();
    }
}
