package Code.BinaryTree.Project07;

import java.util.NoSuchElementException;

public class BinaryTree {

    private TreeNode root;

    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    private class Queue {
        private ListNode front;
        private ListNode rear;
        private int length;

        private class ListNode {
            private TreeNode data;
            private ListNode next;

            public ListNode(TreeNode data) {
                this.data = data;
                this.next = null;
            }
        }

        public Queue() {
            this.front = null;
            this.rear = null;
            length = 0;
        }

        public boolean isEmpty() {
            return length == 0;
        }

        public void enqueue(TreeNode data) {
            ListNode temp = new ListNode(data);
            if (isEmpty()) {
                front = temp;
            } else {
                rear.next = temp;
            }
            rear = temp;
            length++;
        }

        public TreeNode dequeue() {
            if (isEmpty()) {
                throw new NoSuchElementException("Queue is already empty");
            }
            TreeNode result = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            length--;
            return result;
        }
    }

    public void createBinaryTree() {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        root = first;
        first.left = second;
        first.right = third; // second <-- first --> third

        second.left = fourth;
        second.right = fifth;
    }

    public void levelOrderTraversal() {
        if (root == null) {
            return;
        }

        Queue queue = new Queue();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.dequeue();
            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.enqueue(current.left);
            }
            if (current.right != null) {
                queue.enqueue(current.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();

        System.out.print("Level-Order Traversal: ");
        bt.levelOrderTraversal();
    }
}
