package Code.SinglyLinkedList.Project16;

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

    public ListNode insertInSortedList(int value) {
        ListNode newNode = new ListNode(value);

        // Case when the list is empty
        if (head == null) {
            head = newNode;
            return head;
        }

        // Case when the new node should be inserted before the head
        if (newNode.data < head.data) {
            newNode.next = head;
            head = newNode;
            return head;
        }

        ListNode current = head;
        ListNode temp = null;

        // Traverse the list to find the correct insertion point
        while (current != null && current.data < newNode.data) {
            temp = current;
            current = current.next;
        }

        // Insert the new node in its correct position
        newNode.next = current;
        if (temp != null) {
            temp.next = newNode;
        }

        return head;
    }


    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertLast(1);
        sll.insertLast(2);
        sll.insertLast(3);
        sll.insertLast(4);
        sll.insertLast(6);
        sll.display();

        sll.insertInSortedList(5);
        sll.display();


    }
}
